package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;

@Repository
public interface PraticaRepositorio extends JpaRepository<Pratica, Integer> {
	
	@Transactional(readOnly = true)
	TipoMetodologia findByDescricao(String descricao);
}