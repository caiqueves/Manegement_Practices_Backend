package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("SELECT count(1) FROM Usuario u WHERE u.Login = :Login and u.Nome = :Nome and u.Email = :Email")
	Integer ExisteUsuario(@Param("Login") String Login, @Param("Nome") String Nome, @Param("Email") String Email);   
	
}