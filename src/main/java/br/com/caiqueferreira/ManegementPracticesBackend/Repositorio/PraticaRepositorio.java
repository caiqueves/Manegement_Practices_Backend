package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;


@Repository
public interface PraticaRepositorio extends JpaRepository<Pratica, Integer> {
	
	@Transactional(readOnly = true)
	Pratica findByProblema(String problema);
	
	@Transactional(readOnly = true)
	Pratica findBySolucao(String solucao);
	
	@Query("select COUNT(p) from Pratica p")
	Integer findAleatoria();
}