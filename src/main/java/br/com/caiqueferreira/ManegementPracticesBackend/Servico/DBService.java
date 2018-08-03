package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private TipoMetodologiaRepositorio tipoMetodologiaRepositorio;
	

	@Autowired
	public void instantiateTestDatabase() throws ParseException {

		TipoMetodologia tipomet1 = new TipoMetodologia(null,"Metodologias Tradicionais");
		TipoMetodologia tipomet2 = new TipoMetodologia(null,"Metodologias Ageis");
		TipoMetodologia tipomet3 = new TipoMetodologia(null,"Metodologias 3.0");
		
		tipoMetodologiaRepositorio.saveAll(Arrays.asList(tipomet1,tipomet2,tipomet3));
		
		Usuario lg1 = new Usuario(null, "caique ferreira","caique.sire@gmail.com", "09157332428",
				Funcao.GERENTE, pe.encode("12345"));
		lg1.addPerfil(Perfil.ADMIN);
		usuarioRepositorio.save(lg1);
	}
}