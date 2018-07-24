package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.CriarUsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.UsuarioServico;


@RestController
@RequestMapping(value = "/Login")
public class UsuarioRecurso {
 
	@Autowired
	private  UsuarioServico loginServico;
	

	@RequestMapping(value="/Criar",method=RequestMethod.POST)
	public ResponseEntity<Void> CriarLogin(@Valid @RequestBody CriarUsuarioDTO objLoginDto) {
		try {
		Usuario obj = loginServico.fromDTO(objLoginDto);
		
		obj = loginServico.CriarLogin(obj);
		 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
			
		}catch(Exception e){
		  
		}
		
		finally
		{
			
		}
		return null;	
    }
	

	/*@RequestMapping(value="/ListaPermissoes",method = RequestMethod.GET)
	public ResponseEntity<Integer> FazerLogin(@RequestParam("Login") String Login,@RequestParam("Senha") String Senha) throws Exception {
		
		Integer TemAcesso = loginServico.FazerLogin(Login,Senha);
		
		return ResponseEntity.ok().body(TemAcesso);
	}*/
}
