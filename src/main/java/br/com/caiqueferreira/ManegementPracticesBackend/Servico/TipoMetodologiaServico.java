package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.TipoMetodologiaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Security.UserSS;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@Service
public class TipoMetodologiaServico {

	@Autowired
	private TipoMetodologiaRepositorio repositorio;

	@Transactional
	public TipoMetodologia insert(TipoMetodologia obj) {

		UserSS user = UserService.authenticated();
		if (user == null || (user.hasRole(Perfil.ADMIN) && !obj.getId().equals(user.getId()))) {
			throw new AuthorizationException("Acesso negado");
		}

		if (repositorio.findByDescricao(obj.getDescricao()) == null) {
			obj.setId(null);
			obj = repositorio.save(obj);
		} else {
			throw new Excecao(
					"Já existe um cadastro de metodologia, para a descrição:" + obj.getDescricao() + " informada");
		}
		return obj;
	}

	public TipoMetodologia update(TipoMetodologia obj) {

		UserSS user = UserService.authenticated();
		if (user == null || (user.hasRole(Perfil.ADMIN) && !obj.getId().equals(user.getId()))) {
			throw new AuthorizationException("Acesso negado");
		}

		TipoMetodologia newObj = find(obj.getId());
		updateData(newObj, obj);
		repositorio.save(newObj);
		return newObj;
	}

	public void delete(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || (user.hasRole(Perfil.ADMIN) && !id.equals(user.getId()))) {
			throw new AuthorizationException("Acesso negado");
		}

		find(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a metodologia !");
		}
	}

	public TipoMetodologia find(Integer id) {

		Optional<TipoMetodologia> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoMetodologia.class.getName()));
	}

	public List<TipoMetodologia> findAll() {

		UserSS user = UserService.authenticated();
		if (user == null || (user.hasRole(Perfil.ADMIN))) {
			throw new AuthorizationException("Acesso negado");
		}

		return repositorio.findAll();
	}

	private void updateData(TipoMetodologia newObj, TipoMetodologia obj) {

		newObj.setDescricao(obj.getDescricao());
	}

	public TipoMetodologia fromDTO(TipoMetodologiaDTO objDto) {
		TipoMetodologia TipMet = new TipoMetodologia(null, objDto.getDescricao());
		return TipMet;
	}
}
