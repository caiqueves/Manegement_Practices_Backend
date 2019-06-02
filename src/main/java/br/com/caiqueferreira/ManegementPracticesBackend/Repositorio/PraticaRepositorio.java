package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;


@Repository
public interface PraticaRepositorio extends JpaRepository<Pratica, Integer> {
	
	@Transactional(readOnly = true)
	Pratica findByProblema(String problema);
	
	@Transactional(readOnly = true)
	Pratica findBySolucao(String solucao);
	
	@Query("select COUNT(p) from Pratica p where p.tipoMetodologia = 1")
	Integer findQtdPraticaTipoMetodologia1();
	
	@Query("select COUNT(p) from Pratica p where p.tipoMetodologia = 2")
	Integer findQtdPraticaTipoMetodologia2();
	
	@Query("select COUNT(p) from Pratica p where p.tipoMetodologia = 3")
	Integer findQtdPraticaTipoMetodologia3();
	
	@Transactional(readOnly = true)
	Optional<Pratica> findById(Integer id);
	
}