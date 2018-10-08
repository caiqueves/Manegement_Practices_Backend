package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.PraticaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.PraticaServico;

@RestController
@RequestMapping(value = "/pratica")

public class PraticaRecurso {

	@Autowired
	private PraticaServico servico;

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PraticaDTO objDto) {
		Pratica obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pratica> find(@PathVariable Integer id) {
		Pratica obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pratica>> findAll() {
		List<Pratica> obj = servico.findAll();
		return ResponseEntity.ok().body(obj);
	}

	
	@RequestMapping(value = "/aleatoria", method = RequestMethod.GET)
	public ResponseEntity<Pratica> findAleatoria() {
		Pratica obj = servico.findAleatoria();
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PraticaDTO objDto, @PathVariable Integer id) {
		Pratica obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}