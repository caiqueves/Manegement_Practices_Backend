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

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioNovoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = servico.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> find() {
		List<Usuario> obj = servico.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNovoDTO objDto) {
		Usuario obj = servico.fromDTO(objDto);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
		Usuario obj = servico.fromDTO(objDto);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
