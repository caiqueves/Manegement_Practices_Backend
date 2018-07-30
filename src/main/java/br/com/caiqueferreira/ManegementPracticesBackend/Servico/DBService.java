package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;

@Service
public class DBService {
	/*@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public void instantiateTestDatabase() throws ParseException {

		Usuario lg1 = new Usuario(null, "caique ferreira","caique.sire@gmail.com", "09157332428",
				Funcao.GERENTE, pe.encode("12345"));
		usuarioRepositorio.save(lg1);
	}*/
}