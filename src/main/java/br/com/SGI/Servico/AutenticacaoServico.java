package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;

@Service
public class AutenticacaoServico {

	@Autowired
	private UsuarioRepositorio usuRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailServico emailServico;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Usuario usu = usuRepositorio.findByEmail(email);
		
		if (usu == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String novaSenha = NovaSenha();
		
	    usu.setSenha(pe.encode(novaSenha));
		
		usuRepositorio.save(usu);
		emailServico.sendNewPasswordEmail(usu, novaSenha);
		
	}

	private String NovaSenha() {
		char[] vet = new char[10];
		for (int i = 0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}
	
	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
