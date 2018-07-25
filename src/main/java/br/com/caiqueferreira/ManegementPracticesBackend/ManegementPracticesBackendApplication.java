package br.com.caiqueferreira.ManegementPracticesBackend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.PerfilRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;


@SpringBootApplication
public class ManegementPracticesBackendApplication implements CommandLineRunner {
    
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PerfilRepositorio perfilRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ManegementPracticesBackendApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		Perfil pe1 = new Perfil(null, "Gerente");
		Perfil pe2 = new Perfil(null, "Analista");
		
		perfilRepositorio.saveAll(Arrays.asList(pe1, pe2));
		
		Usuario lg1 = new Usuario(null,"caiqueferreira", "123456", "caique ferreira", "caique.sire@gmail.com");
		lg1.setPerfil(pe1);
		
		usuarioRepositorio.save(lg1);
		
	}
}
