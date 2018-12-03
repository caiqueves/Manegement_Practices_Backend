package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioNovoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.UsuarioServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.UsernameNotFoundException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody UsuarioNovoDTO objDto) throws Excecao {
		try {
			Usuario obj = servico.fromDTO(objDto);
			obj = servico.insert(obj);
			//URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			//		.path("/{id}").buildAndExpand(obj.getId()).toUri();
			//return ResponseEntity.created(uri).build();	
			return ResponseEntity.badRequest().body("{\"id\": \"" +obj.getId() + "\",\"message\": \"Usuário cadastrado com sucesso!\"}"); 
		}catch(Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \""+ e.getMessage() +"\"}");
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
	  try {
		Usuario obj = servico.find(id);
		return ResponseEntity.badRequest().body(obj);
	  }catch( UsernameNotFoundException e) {
		return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}"); 
	    }
	}
	
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> find() {
		List<Usuario> obj = servico.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id)  {
		try {
		Usuario obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.badRequest().body("{\"message\": \"Usuário alterado com sucesso!\"}"); 
		}catch(AuthorizationException e) {
			return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}"); 
		}catch( ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}"); 
		}catch( Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}"); 
		}
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
