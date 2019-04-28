package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.PraticaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.PraticaServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthenticacaoExcecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pratica")

public class PraticaRecurso {

	@Autowired
	private PraticaServico servico;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody PraticaDTO objDto) {
		try {
			Pratica obj = servico.fromDTO(objDto);
			obj = servico.insert(obj);
			
			return ResponseEntity.badRequest()
					.body("{\"id\": \"" + obj.getId() + "\",\"message\": \"Prática cadastrada com sucesso !\"}");

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		try {
			Pratica obj = servico.find(id);
			return ResponseEntity.ok().body(obj);

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Prática não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		try {
			List<Pratica> obj = servico.findAll();
			return ResponseEntity.ok().body(obj);

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Prática não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody PraticaDTO objDto, @PathVariable Integer id) {
		try {
			Pratica obj = servico.fromDTO(objDto);
			obj.setId(id);
			obj = servico.update(obj);
			return ResponseEntity.badRequest().body("{\"message\": \"Prática alterada com sucesso!\"}");

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Prática não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			servico.delete(id);
			return ResponseEntity.badRequest().body("{\"message\": \"Prática excluída com sucesso!\"}");

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Prática não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}
}