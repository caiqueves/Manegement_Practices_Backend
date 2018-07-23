package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



public class Login  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(insertable=false, updatable=false)
	private Integer Id;
	
	@OneToMany
	@JoinColumn(name="TipoPerfil_id")
	private List<TipoPerfil> tipoPerfil = new ArrayList<>();
	
	private String Login;
	
	private String Senha;
	
	private String Nome;
	
	private String Email;

	public Login () {}
	
	public Login(Integer id,String login, String senha, String nome, String email) {
		super();
		Id = id;
		Login = login;
		Senha = senha;
		Nome = nome;
		Email = email;
	}

	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public List<TipoPerfil> getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(List<TipoPerfil> tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
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
