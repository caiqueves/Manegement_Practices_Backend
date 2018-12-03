package br.com.caiqueferreira.ManegementPracticesBackend.Servico;



import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.PraticaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.TipoMetodologiaRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;

@Service
public class DBServico {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private TipoMetodologiaRepositorio tipoMetodologiaRepositorio;
	
	@Autowired
	private PraticaRepositorio praticaRepositorio;

	@Autowired
	public void instantiateTestDatabase() throws ParseException {

		TipoMetodologia tipomet1 = new TipoMetodologia(null,"Metodologias Tradicionais");
	    TipoMetodologia tipomet2 = new TipoMetodologia(null,"Metodologias Ageis");
		TipoMetodologia tipomet3 = new TipoMetodologia(null,"Metodologias 3.0");
		
		tipoMetodologiaRepositorio.saveAll(Arrays.asList(tipomet1,tipomet2,tipomet3));
		
		
		Pratica pra1 = new Pratica(null, "teste1", tipomet1);
		Pratica pra2 = new Pratica(null, "teste2", tipomet1);
		Pratica pra3 = new Pratica(null, "teste3", tipomet1);
		Pratica pra4 = new Pratica(null, "teste4", tipomet1);
		Pratica pra5 = new Pratica(null, "teste5", tipomet1);
		Pratica pra6 = new Pratica(null, "teste6", tipomet1);
		Pratica pra7 = new Pratica(null, "teste7", tipomet1);
		
		praticaRepositorio.saveAll(Arrays.asList(pra1,pra2,pra3,pra4,pra5,pra6,pra7));
		
		
	
				
		Usuario lg1 = new Usuario(null, "caique ferreira","caique.sire2@gmail.com", "09157332428",
				Funcao.GERENTE, pe.encode("12345"));
		lg1.addPerfil(Perfil.ADMIN);
		usuarioRepositorio.save(lg1);
		
		
	}
}