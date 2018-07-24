package br.com.caiqueferreira.ManegementPracticesBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;


@SpringBootApplication
public class ManegementPracticesBackendApplication implements CommandLineRunner {
    
	@Autowired
	private UsuarioRepositorio loginRepositorio;
		
	public static void main(String[] args) {
		SpringApplication.run(ManegementPracticesBackendApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		
		Usuario lg1 = new Usuario(null,"caiqueferreira", "123456", "caique ferreira", "caiqeu.sire@gmail.com");
		loginRepositorio.save(lg1);
		
	}
}
