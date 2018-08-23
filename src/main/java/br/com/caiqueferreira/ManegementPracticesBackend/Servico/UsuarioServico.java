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
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.UserSS;
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

	@Autowired
	private EmailServico emailService;

	@Transactional
	public Usuario insert(Usuario obj) {

		try {
			if (findByCpfOuCnpj(obj.getCpfOuCnpj()) != null)
				throw new Excecao("Já existe um cadastro para o CPF:   " + obj.getCpfOuCnpj() + " informado.");

			if (findByEmail(obj.getEmail()) != null)
				throw new Excecao("Já existe um cadastro para o Email: " + obj.getEmail() + " informado.");

			List<String> lstDadosEmail = new ArrayList<>();

			lstDadosEmail.add(" Confirmação de Cadastro");
			lstDadosEmail.add(obj.getNome());
			lstDadosEmail.add(obj.getEmail());
			lstDadosEmail.add("Senha : " + obj.getSenha());

			obj.setId(null);
			obj.setSenha(pe.encode(obj.getSenha()));
			obj = usuarioRepositorio.save(obj);

			emailService.sendOrderConfirmationEmail(lstDadosEmail);
			lstDadosEmail = null;
			return obj;

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível inserir o usuário. Tipo: " + e.getMessage());
		}
	}
	
	public Usuario find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}
		Optional<Usuario> obj = usuarioRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		List<Usuario> usulist = usuarioRepositorio.findAll();

		if (usulist.isEmpty()) {
			throw new ObjectNotFoundException("Não existem dados. Tipo: " + Pratica.class.getName());
		}
		return usulist;
	}

	public Usuario findByEmail(String email) {

		Usuario usu = usuarioRepositorio.findByEmail(email);
		if (usu == null) {
			new ObjectNotFoundException("Email: " + email + "não encontrado , Tipo: " + Usuario.class.getName());
		}
		return usu;
	}

	public Usuario findByCpfOuCnpj(String CpfOuCnpj) {

		Usuario usu = usuarioRepositorio.findByCpfOuCnpj(CpfOuCnpj);
		if (usu == null) {
			new ObjectNotFoundException(
					"CpfOuCnpj : " + CpfOuCnpj + "não encontrado , Tipo: " + Usuario.class.getName());
		}
		return usu;
	}
	
	public Usuario update(Usuario obj) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !obj.getId().equals(user.getId())) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		try {
			Usuario usu = findByEmail(obj.getEmail());
			if (usu != null && !obj.getId().equals(usu.getId()))
				throw new Excecao("Já existe um cadastro para o Email: " + obj.getEmail() + " informado.");

			List<String> lstDadosEmail = new ArrayList<>();

			lstDadosEmail.add(" Alteração de Cadastro");
			lstDadosEmail.add(obj.getNome());
			lstDadosEmail.add(obj.getEmail());
			lstDadosEmail.add("Senha : " + obj.getSenha());

			Usuario newObj = find(obj.getId());
			updateData(newObj, obj);
			usuarioRepositorio.save(newObj);

			emailService.sendOrderConfirmationEmail(lstDadosEmail);
			return newObj;

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel alterar o usuário. Tipo: " + e.getMessage());
		}
	}

	public void delete(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		find(id);
		try {
			usuarioRepositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir o usuário. Tipo: " + e.getMessage());
		}
	}

	public Usuario fromDTO(UsuarioNovoDTO objDto) {

		Usuario usu = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				Funcao.toEnum(objDto.getTipoFuncao()), objDto.getSenha());

		if (objDto.getListaTipoMetodologia() == null) {
			throw new Excecao("É necessário informar pelo menos um tipo de metodologia.");
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

		Usuario usu = new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), null,
				Funcao.toEnum(objDto.getTipoFuncao()), objDto.getSenha());

		if (objDto.getListaTipoMetodologia() == null) {
			throw new Excecao("É necessário informar pelo menos um tipo de metodologia.");
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
		newObj.setEmail(obj.getEmail());
		newObj.setTipoFuncao(obj.getTipoFuncao());
		newObj.setSenha(pe.encode(obj.getSenha()));
		newObj.setListaTipoMetodologia(obj.getListaTipoMetodologia());
	}
}
