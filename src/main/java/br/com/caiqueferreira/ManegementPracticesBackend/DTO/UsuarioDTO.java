package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

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
	
	private Integer IdTipoFuncao;
	
	
	private String senha;
    
	private Integer IdTipoMetodologia;
	
	public UsuarioDTO() {}

	/*
	public UsuarioDTO(Usuario obj) 
	{	
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		//senha = obj.getSenha();	
	}
   */
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

	public Integer getIdTipoFuncao() {
		return IdTipoFuncao;
	}

	public void setIdTipoFuncao(Integer idTipoFuncao) {
		IdTipoFuncao = idTipoFuncao;
	}

	public Integer getIdTipoMetodologia() {
		return IdTipoMetodologia;
	}

	public void setIdTipoMetodologia(Integer idTipoMetodologia) {
		IdTipoMetodologia = idTipoMetodologia;
	}
    
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}