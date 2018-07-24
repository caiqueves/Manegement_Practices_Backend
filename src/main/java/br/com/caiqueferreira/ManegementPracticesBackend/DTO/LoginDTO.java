package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"Id", "TipoPerfil", "Login", "Senha", "Nome", "Email"})
public class LoginDTO {
    
	@NotNull
    private Integer Id;
	@NotNull
	private Integer TipoPerfil;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String Login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String Senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String Nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email
	private String Email;
	
	
	public LoginDTO() {}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getTipoPerfil() {
		return TipoPerfil;
	}


	public void setTipoPerfil(Integer tipoPerfil) {
		TipoPerfil = tipoPerfil;
	}


	public String getLogin() {
		return Login;
	}


	public void setLogin(String login) {
		Login = login;
	}


	public String getSenha() {
		return Senha;
	}


	public void setSenha(String senha) {
		Senha = senha;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

}
