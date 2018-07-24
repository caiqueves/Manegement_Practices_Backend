package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Login;


@Repository
public interface LoginRepositorio extends JpaRepository<Login, Integer> {

	
	/*@Transactional
	@Modifying
	
	@Query("INSERT INTO Login(Login,Senha,Nome,Email )"
			+ " VALUES(:id,:Login,:Senha,:Nome,"
			+ ":Email)")
	
	void CriarLogin(
			@Param("Login") String Login, @Param("Senha") String Senha,
			@Param("Nome") String Nome, @Param("Email") String Email );
  */
	
	
	@Query("SELECT count(1) FROM Login u WHERE u.Login = :Login and u.Senha = :Senha")
	Integer FazerLogin(@Param("Login") String Login, @Param("Senha") String Senha );   
	
	
	

}