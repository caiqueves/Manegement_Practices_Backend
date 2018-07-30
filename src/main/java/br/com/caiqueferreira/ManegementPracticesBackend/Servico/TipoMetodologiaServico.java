package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;


@Service
public class TipoMetodologiaServico {

	@Autowired
	private TipoMetodologiaRepositorio  tipoMetodologiaRepositorio;
   
	public TipoMetodologia find(Integer id) {

		//UserSS user = UserService.authenticated();
		//if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
		//	throw new AuthorizationException("Acesso negado");
		//}

		Optional<TipoMetodologia> obj = tipoMetodologiaRepositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
