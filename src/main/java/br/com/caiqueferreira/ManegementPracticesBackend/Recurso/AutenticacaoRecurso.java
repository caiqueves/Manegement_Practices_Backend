package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.EmailDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.JWTUtil;
import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.UserSS;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.AutenticacaoServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.UserService;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoRecurso {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AutenticacaoServico autservico;
	
	
	@RequestMapping(value = "/atualizar_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/esqueciSenha", method = RequestMethod.POST)
	public ResponseEntity<Void> EsqueciSenha(@Valid @RequestBody EmailDTO objDTO) {
		autservico.sendNewPassword(objDTO.getEmail());
		return ResponseEntity.noContent().build();
	}
	
}
