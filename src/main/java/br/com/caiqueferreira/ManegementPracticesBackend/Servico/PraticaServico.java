package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.PraticaRepositorio;


@Service
public class PraticaServico {

	@Autowired
	private PraticaRepositorio  praticaRepositorio;
   
}
