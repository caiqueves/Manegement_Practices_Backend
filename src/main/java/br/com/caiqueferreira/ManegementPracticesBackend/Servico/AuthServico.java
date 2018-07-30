package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.stereotype.Service;

@Service
public class AuthServico {

	/*@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailServico emailServico;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		if (usuario == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		usuario.setSenha(pe.encode(newPass));
		
		usuarioRepositorio.save(usuario);
		emailServico.sendNewPasswordEmail(usuario, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
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
	}*/
}