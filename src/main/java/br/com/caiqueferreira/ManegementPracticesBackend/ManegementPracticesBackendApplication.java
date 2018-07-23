package br.com.caiqueferreira.ManegementPracticesBackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Login;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoPerfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.LoginRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoPerfilRepositorio;

@SpringBootApplication
public class ManegementPracticesBackendApplication implements CommandLineRunner {
    
	@Autowired
	private LoginRepositorio loginRepositorio;
	
	@Autowired
	private TipoPerfilRepositorio tipoPerfilRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ManegementPracticesBackendApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		
		TipoPerfil tp1 = new   TipoPerfil(1, "Gerente");
		
		tipoPerfilRepositorio.save(tp1);
		
		List<TipoPerfil> tipoperfil2 = new ArrayList<>();
		tipoperfil2.add(tp1);
		
		
		Login lg1 = new Login(1,1 "caiqueferreira", "123456", "caique ferreira", "caiqeu.sire@gmail.com");
		
		loginRepositorio.save(lg1);
		
		
	}
}
