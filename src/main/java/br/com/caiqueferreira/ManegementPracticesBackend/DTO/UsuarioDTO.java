package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

//@JsonPropertyOrder({"id","nome","email","tipoFuncao","senha","listaTipoMetodologia"})
public class UsuarioDTO {

	private Integer id;
	
	@NotEmpty(message = "Por favor, informe o nome. Preenchimento obrigatório !")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório !")
	@Email(message = "Email inválido")
	private String email;
	
	private Integer tipoFuncao;
	
	//private String senha;
    
	private List<Integer> listaTipoMetodologia;
	
	public UsuarioDTO() {}

	public UsuarioDTO(Usuario obj) 
	{	
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		//senha = obj.getSenha();	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(Integer tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}
    
	/*
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
    */
	
	public List<Integer> getListaTipoMetodologia() {
		return listaTipoMetodologia;
	}

	public void setListaTipoMetodologia(List<Integer> listaTipoMetodologia) {
		this.listaTipoMetodologia = listaTipoMetodologia;
	}
}
