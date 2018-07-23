package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoPerfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoPerfilRepositorio;


@Service
public class TipoPerfilServico {

	@Autowired
	private TipoPerfilRepositorio  tipoPerfilRepositorio;

	public TipoPerfil buscarPorId(Integer Id) {
		return tipoPerfilRepositorio.buscaPorId(Id);
	}
    
	
}