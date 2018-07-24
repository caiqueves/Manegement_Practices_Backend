package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.CriarUsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;


@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio  usuarioRepositorio;
    
	public Usuario fromDTO(CriarUsuarioDTO objDto) {
		return new Usuario(null, objDto.getLogin(),objDto.getSenha(),objDto.getNome(), objDto.getEmail());
	}
	
	public Usuario CriarLogin(Usuario obj) {
		obj.setId(null);
		return usuarioRepositorio.save(obj);
	}	
		
	
	/*public Integer FazerLogin(String Login, String Senha) throws Exception {
		
		if (Login == null) {
			throw new Exception("Preenchimento do login é obrigatório");
		}

		if (Senha == null) {
			throw new Exception("Preenchimento da senha é obrigatória");
		}

		return loginRepositorio.FazerLogin(Login, Senha);

	}*/
    
}
