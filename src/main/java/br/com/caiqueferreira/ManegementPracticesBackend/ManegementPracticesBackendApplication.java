package br.com.caiqueferreira.ManegementPracticesBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.PraticaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;

@SpringBootApplication
public class ManegementPracticesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private TipoMetodologiaRepositorio tipoMetodologiaRepositorio;

	@Autowired
	private PraticaRepositorio praticaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ManegementPracticesBackendApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		/*
		 * Usuario lg1 = new Usuario(null, "caique ferreira", "caique",
		 * "caique.sire@gmail.com", "09157332428", Funcao.GERENTE, pe.encode("12345"));
		 * 
		 * TipoMetodologia Tp1 = new TipoMetodologia(null, "Metodologia Ageis");
		 * 
		 * Tp1.getUsuarios().addAll(Arrays.asList(lg1));
		 * lg1.getTipoMetodologias().addAll(Arrays.asList(Tp1));
		 * 
		 * tipoMetodologiaRepositorio.save(Tp1);
		 * 
		 * usuarioRepositorio.save(lg1);
		 * 
		 * Pratica n1 = new Pratica(null, "Uma gerencia que acompanha tudo", Tp1);
		 * praticaRepositorio.save(n1);
		 */
	}
}
