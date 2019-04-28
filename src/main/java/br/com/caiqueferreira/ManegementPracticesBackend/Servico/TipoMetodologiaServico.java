package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.TipoMetodologiaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.UserSS;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.UsernameNotFoundException;

@Service
public class TipoMetodologiaServico {

	@Autowired
	private TipoMetodologiaRepositorio repositorio;
	
	@Transactional
	public TipoMetodologia insert(TipoMetodologia obj) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new UsernameNotFoundException("O usuário não foi localizado.");
		} else if (!user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		try {
			
			if (repositorio.findByDescricao(obj.getDescricao()) != null) {
				throw new Excecao("Já existe um cadastro para a descrição: " + obj.getDescricao() + " informado.");
			}
			
			obj.setId(null);
			obj = repositorio.save(obj);
			return obj;

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível inserir o tipo de metodologia. Tipo: " + e.getMessage());
		}
	}

	public TipoMetodologia find(Integer id) {
		Optional<TipoMetodologia> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoMetodologia.class.getName()));
	}

	public List<TipoMetodologia> findAll() {
     
		List<TipoMetodologia> metolist = repositorio.findAll();

		if (metolist.isEmpty()) {
			throw new ObjectNotFoundException("Não existem dados. Tipo: " + TipoMetodologia.class.getName());
		}

		return metolist;
	}

	public TipoMetodologia update(TipoMetodologia obj) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new UsernameNotFoundException("O usuário não foi localizado.");
		} else if (!user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		if (repositorio.findByDescricao(obj.getDescricao()) != null) {
			throw new Excecao("Já existe um cadastro para a descrição: " + obj.getDescricao() + " informado.");
		}

		TipoMetodologia newObj = find(obj.getId());

		updateData(newObj, obj);
		try {
			repositorio.save(newObj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível alterar o tipo de metodologia. Tipo: " + e.getMessage());
		}

		return newObj;
	}

	public void delete(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new UsernameNotFoundException("O usuário não foi localizado.");
		} else if (!user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		find(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o tipo de metodologia. Tipo: " + e.getMessage());
		}
	}

	public TipoMetodologia fromDTO(TipoMetodologiaDTO objDto) {
		TipoMetodologia TipMet = new TipoMetodologia(null, objDto.getDescricao());
		return TipMet;
	}

	private void updateData(TipoMetodologia newObj, TipoMetodologia obj) {

		newObj.setDescricao(obj.getDescricao());
	}
}
