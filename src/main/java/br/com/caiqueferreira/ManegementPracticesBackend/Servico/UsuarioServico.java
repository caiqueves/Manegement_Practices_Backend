package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioNovoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Security.UserSS;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private TipoMetodologiaServico tipoMetodologiaServico;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Usuario find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Transactional
	public Usuario insert(Usuario obj) {

		if (usuarioRepositorio.findByCpfOuCnpj(obj.getCpfOuCnpj()) != null)
			throw new Excecao("Já existe um cadastro para o CPF: " + obj.getCpfOuCnpj() + " informado");

		if (usuarioRepositorio.findByEmail(obj.getEmail()) != null)
			throw new Excecao("Já existe um cadastro para o Email: " + obj.getEmail() + " informado");

		obj.setId(null);
		obj = usuarioRepositorio.save(obj);
		return obj;
	}

	
	public Usuario update(Usuario obj) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !obj.getId().equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		usuarioRepositorio.save(newObj);
		return newObj;
	}

	public void delete(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		find(id);
		try {
			usuarioRepositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o usuário !");
		}
	}

	public List<Usuario> findAll() {

		UserSS user = UserService.authenticated();
		if (user == null || user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("Acesso negado");
		}

		return usuarioRepositorio.findAll();
	}

	public Usuario findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Usuario obj = usuarioRepositorio.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

	public Usuario fromDTO(UsuarioNovoDTO objDto) {

		Usuario usu = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				Funcao.toEnum(objDto.getTipoFuncao()), pe.encode(objDto.getSenha()));

		if ((objDto.getListaTipoMetodologia().isEmpty())) {
			throw new Excecao("É necessário informar pelo menos um tipo de metodologia");
		}

		List<TipoMetodologia> listTpMetodologia = new ArrayList<>();

		for (Integer i : objDto.getListaTipoMetodologia()) {
			TipoMetodologia tpMeto = (TipoMetodologia) tipoMetodologiaServico.find(i);
			listTpMetodologia.add(tpMeto);
		}

		usu.setListaTipoMetodologia(listTpMetodologia);
		return usu;
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		Usuario usu = new Usuario(objDto.getId(), objDto.getNome(), null, null, Funcao.toEnum(objDto.getTipoFuncao()),
				pe.encode(objDto.getSenha()));

		if ((objDto.getListaTipoMetodologia().isEmpty())) {
			throw new Excecao("É necessário informar pelo menos um tipo de metodologia");
		}

		List<TipoMetodologia> listTpMetodologia = new ArrayList<>();

		for (Integer i : objDto.getListaTipoMetodologia()) {
			TipoMetodologia tpMeto = (TipoMetodologia) tipoMetodologiaServico.find(i);
			listTpMetodologia.add(tpMeto);
		}

		usu.setListaTipoMetodologia(listTpMetodologia);
		return usu;
	}

	private void updateData(Usuario newObj, Usuario obj) {

		newObj.setNome(obj.getNome());
		newObj.setTipoFuncao(obj.getTipoFuncao());
		newObj.setSenha(obj.getSenha());
		newObj.setListaTipoMetodologia(obj.getListaTipoMetodologia());
	}
}
