package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/FazerLogin",method = RequestMethod.GET)
	public ResponseEntity<Integer> buscarRequisitorio(@Valid @RequestBody LoginDTO loginDto) {
		
		Integer TemAcesso = loginServico.VerificaAcesso(loginDto.getLogin(),loginDto.getSenha());
		return ResponseEntity.ok().body(TemAcesso);
	}
}
