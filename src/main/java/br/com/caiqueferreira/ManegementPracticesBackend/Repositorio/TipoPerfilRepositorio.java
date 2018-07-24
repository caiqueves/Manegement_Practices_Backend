package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoPerfil;

@Repository
public interface TipoPerfilRepositorio extends JpaRepository<TipoPerfil, Integer> {

	@Query("SELECT u FROM TipoPerfil u WHERE u.Id = :Id")
	TipoPerfil buscaPorId(@Param("Id") Integer Id );   
}
