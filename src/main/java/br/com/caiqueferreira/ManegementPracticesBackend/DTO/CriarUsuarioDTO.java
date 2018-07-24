package br.com.caiqueferreira.ManegementPracticesBackend.DTO;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

@JsonPropertyOrder(value = {"Login", "Senha", "Nome", "Email"})
public class CriarUsuarioDTO {
    

	@NotEmpty(message="Preenchimento do login é obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento da senha é obrigatória")
	private String senha;
	
	@NotEmpty(message="Preenchimento do nome é obrigatório")
	private String nome;
		
	@NotEmpty(message="Preenchimento do email  é obrigatório")
	@Email(message = "Email não é válido")
	private String email;
	
	
	public CriarUsuarioDTO() {}
    

	public CriarUsuarioDTO(Usuario obj) {
		
		login = obj.getLogin();
		senha = obj.getSenha();
		email = obj.getEmail();
	}


	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	

}
