package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.LoginDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.LoginServico;


@RestController
@RequestMapping(value = "/Login")
public class LoginRecurso {
 
	@Autowired
	private  LoginServico loginServico;
	
	@RequestMapping(value="/CriarLogin",method = RequestMethod.POST)
	public ResponseEntity<Integer> CriarLogin(@Valid @RequestBody LoginDTO loginDto) {
		
		 loginServico.CriarLogin(loginDto.getLogin(),
				loginDto.getSenha(),loginDto.getNome(),loginDto.getEmail());
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(value="/FazerLogin/{login,senha}",method = RequestMethod.GET)
	public ResponseEntity<Integer> buscarLogin(@PathVariable String Login, String Senha) {
		
		Integer TemAcesso = loginServico.FazerLogin(Login,Senha);
		return ResponseEntity.ok().body(TemAcesso);
	}
}
