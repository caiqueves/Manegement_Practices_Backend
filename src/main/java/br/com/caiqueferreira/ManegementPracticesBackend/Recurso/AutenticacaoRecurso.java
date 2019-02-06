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
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthenticacaoExcecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoRecurso {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AutenticacaoServico autservico;

	@RequestMapping(value = "/atualizar_token", method = RequestMethod.POST)
	public ResponseEntity<?> refreshToken(HttpServletResponse response) {
		try {
			UserSS user = UserService.authenticated();
			String token = jwtUtil.generateToken(user.getUsername());
			response.addHeader("Authorization", "Bearer " + token);
			response.addHeader("access-control-expose-headers", "Authorization");
			return ResponseEntity.noContent().build();

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(value = "/esqueciSenha", method = RequestMethod.POST)
	public ResponseEntity<?> EsqueciSenha(@Valid @RequestBody EmailDTO objDTO) {
		try {
			autservico.sendNewPassword(objDTO.getEmail());
			return ResponseEntity.ok()
					.body("{\"message\": \"Senha enviada com sucesso, para o e-mail informado!\"}");
			
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}
}
