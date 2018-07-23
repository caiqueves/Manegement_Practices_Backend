package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;

import java.util.Date;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Login;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Notificacao;

@Repository
public interface LoginRepositorio extends JpaRepository<Login, Integer> {

	@Query("SELECT count(1)  FROM Login u WHERE u.Login = :Login and u.Senha = :Senha")
	Integer VerificaAcesso(@Param("Login") String Login, @Param("Senha") String Senha );   
	
	/*
	@Transactional
	@Modifying
	@Query("UPDATE ResultadoAutuacao u SET u.CodDocEsparta  = :CodDocEsparta, u.NumProcEsparta = :NumProcEsparta,"
			+ "u.Classe = :Classe,  u.NumProc1Grau=	:NumProc1Grau,  u.Dthrautuaenvio  = :Dthrautuaenvio, "
			+ "u.Codvara= :Codvara, u.Vara   =      :Vara,          u.Codcid          = :Codcid,        u.Cidade  = :Cidade, "
			+ "u.CodUf =  :CodUf,   u.Autuado=      :Autuado,       u.Dthrautuacao    = :Dthrautuacao,  u.DescErro        = :DescErro,"
			+ "u.Origem=  :Origem,  u.UsuIncl=      :UsuIncl,       u.DthrVerif       = :DthrVerif,     u.Registrado1Grau = :Registrado1Grau"
			+" WHERE u.NUMREQ = :Numreq")
	
	Integer atualizarPorRequisitorio(@Param("CodDocEsparta") Integer CodDocEsparta,
			@Param("NumProcEsparta") String NumProcEsparta, @Param("Classe") String Classe,
			@Param("NumProc1Grau") String NumProc1Grau, @Param("Dthrautuaenvio") Date Dthrautuaenvio,
			@Param("Codvara") Integer Codvara, @Param("Vara") String Vara, @Param("Codcid") Integer Codcid,
			@Param("Cidade") String Cidade, @Param("CodUf") String CodUf, @Param("Autuado") String Autuado,
			@Param("Dthrautuacao") Date Dthrautuacao, @Param("DescErro") String DescErro,
			@Param("Origem") String Origem, @Param("UsuIncl") String UsuIncl, @Param("DthrVerif") Date DthrVerif,
			@Param("Registrado1Grau") String Registrado1Grau,@Param("Numreq") String Numreq );
  */
	

}