package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;

@Repository
public interface TipoMetodologiaRepositorio extends JpaRepository<TipoMetodologia, Integer> {

	@Transactional(readOnly = true)
	TipoMetodologia findByDescricao(String descricao);

}