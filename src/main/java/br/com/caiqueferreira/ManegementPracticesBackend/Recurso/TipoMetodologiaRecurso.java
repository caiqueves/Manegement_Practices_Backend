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

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.TipoMetodologiaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.TipoMetodologiaServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthenticacaoExcecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/tipoMetodologia")
public class TipoMetodologiaRecurso {

	@Autowired
	private TipoMetodologiaServico servico;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody TipoMetodologiaDTO objDto) {
		try {
			TipoMetodologia obj = servico.fromDTO(objDto);
			obj = servico.insert(obj);
			
			return ResponseEntity.badRequest()
					.body("{\"id\": \"" + obj.getId() + "\",\"message\": \"Metodologia cadastrada com sucesso !\"}");

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
			TipoMetodologia obj = servico.find(id);
			return ResponseEntity.badRequest().body(obj);

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		try {
			List<TipoMetodologia> obj = servico.findAll();
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
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody TipoMetodologiaDTO objDto, @PathVariable Integer id) {
		try {
			TipoMetodologia obj = servico.fromDTO(objDto);
			obj.setId(id);
			obj = servico.update(obj);
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia alterada com sucesso!\"}");

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			servico.delete(id);
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia excluída com sucesso!\"}");

		} catch (AuthenticacaoExcecao e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Não foi possível efetuar a authenticacao com o servidor.\"}");
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"O Usuário não tem permissão para acessar esse serviço\"}");
		} catch (DataIntegrityException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Metodologia não encontrada!\"}");
		} catch (Excecao e) {
			return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\"}");
		}
	}
}