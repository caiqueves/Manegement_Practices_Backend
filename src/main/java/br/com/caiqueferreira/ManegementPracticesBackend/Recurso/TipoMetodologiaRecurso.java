package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.TipoMetodologiaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.TipoMetodologiaServico;

@RestController
@RequestMapping(value = "/tipoMetodologia")
public class TipoMetodologiaRecurso {

	@Autowired
	private TipoMetodologiaServico servico;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoMetodologia> find(@PathVariable Integer id) {
		TipoMetodologia obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TipoMetodologiaDTO objDto) {
		TipoMetodologia obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TipoMetodologiaDTO objDto, @PathVariable Integer id) {
		TipoMetodologia obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}