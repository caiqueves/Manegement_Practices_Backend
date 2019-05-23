package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.UsuarioServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthenticacaoExcecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody UsuarioDTO objDto) throws Excecao {
		try {
			Usuario obj = servico.fromDTO(objDto);
			obj = servico.insert(obj);
			
			return ResponseEntity.ok().body("{\"id\": \"" +obj.getId() + "\",\"message\": \"Usuário cadastrado com sucesso!\"}"); 
		}catch(AuthenticacaoExcecao e) {
		    	return ResponseEntity.badRequest().body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}"); 
		}catch(AuthorizationException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}"); 
		}catch (DataIntegrityException e ) {
			return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}");	
		}catch( Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \""+e.getMessage()+"\"}"); 
		}		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		try {
			Usuario obj = servico.find(id);
			return ResponseEntity.ok().body(obj);
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(value = "/emailUsuario/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> findUsuarioEmail(@PathVariable String email) {
		try {
			Usuario obj = servico.findByEmail(email);
			return ResponseEntity.ok().body(obj);
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		try {
			List<Usuario> obj = servico.findAll();
			return ResponseEntity.ok().body(obj);
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
		try {

			Usuario obj = servico.fromDTO(objDto);
			obj.setId(id);
			obj = servico.update(obj);
			return ResponseEntity.ok().body("{\"message\": \"Usuário alterado com sucesso!\"}");

		} catch (UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {

			servico.delete(id);
			return ResponseEntity.ok().body("{\"message\": \"Usuário excluído com sucesso!\"}");

		} catch (UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Usuário não encontrado!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}
}
