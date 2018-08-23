package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.PraticaDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.PraticaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.UserSS;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@Service
public class PraticaServico {

	@Autowired
	private PraticaRepositorio repositorio;

	@Autowired
	private TipoMetodologiaServico tipoMetodologiaServico;

	private Random rand = new Random();
	
	@Transactional
	public Pratica insert(Pratica obj) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}
		try {
			obj.setId(null);
			obj = repositorio.save(obj);
			return obj;

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível inserir a prática. Tipo: " + e.getMessage());
		}
	}

	public Pratica find(Integer id) {
		Optional<Pratica> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pratica.class.getName()));
	}

	public List<Pratica> findAll() {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		List<Pratica> pralist = repositorio.findAll();

		if (pralist.isEmpty()) {
			throw new ObjectNotFoundException("Não existem dados. Tipo: " + Pratica.class.getName());
		}

		return pralist;
	}

	public Pratica findAleatoria()
	{  
		Pratica pra = find((int)BetweenRange(1,repositorio.findAleatoria()));
		return pra;
		
	}
	
	public static double BetweenRange(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public Pratica update(Pratica obj) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		if (repositorio.findByDescricao(obj.getDescricao()) != null) {
			throw new Excecao("Já existe um cadastro para a descrição: " + obj.getDescricao() + " informado.");
		}
		try {
			Pratica newObj = find(obj.getId());
			updateData(newObj, obj);
			repositorio.save(newObj);
			return newObj;

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível alterar a prática. Tipo: " + e.getMessage());
		}
	}

	public void delete(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("O seu usuário não tem permissão ao serviço.");
		}

		find(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir a prática. . Tipo: " + e.getMessage());
		}
	}

	public Pratica fromDTO(PraticaDTO objDto) {

		if (objDto.getTipoMetodologia() == null) {
			throw new Excecao("É necessário informar pelo menos um tipo de metodologia.");
		}

		TipoMetodologia tpMeto = (TipoMetodologia) tipoMetodologiaServico.find(objDto.getTipoMetodologia());

		Pratica pra = new Pratica(null, objDto.getDescricao(), tpMeto);

		return pra;
	}

	private void updateData(Pratica newObj, Pratica obj) {

		newObj.setDescricao(obj.getDescricao());
	}
}
