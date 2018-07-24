package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name="Usuario")
public class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="usuario_perfil",
              joinColumns={@JoinColumn(name="usuario_id",  
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="perfil_id",   
               referencedColumnName="id")})  
	private TipoPerfil tipoPerfil;
	

	private String Login;
	
	private String Senha;
	
	private String Nome;
	
	private String Email;

	public Usuario () {}
	
	public Usuario(Integer id,String login, String senha, String nome, String email) {
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
