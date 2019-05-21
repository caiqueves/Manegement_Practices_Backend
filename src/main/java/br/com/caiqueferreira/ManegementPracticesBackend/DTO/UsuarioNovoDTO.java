package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class UsuarioNovoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Por favor, informe o nome. Preenchimento obrigatório !")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório !")
	@Email(message = "Email inválido")
	private String email;

	private Integer idTipoFuncao;

	@NotEmpty(message = "Por favor, informe a senha. Preenchimento obrigatório !")
	@Length(min = 6, max = 10, message = "O tamanho deve ter entre 6 a 10 caracteres")
	private String senha;

	private Integer idTipoMetodologia;

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

	
	/*
	public List<Integer> getListaTipoMetodologia() {
		return listaTipoMetodologia;
	}

	public void setListaTipoMetodologia(List<Integer> listaTipoMetodologia) {
		this.listaTipoMetodologia = listaTipoMetodologia;
	}
    */
	
	
	
	public Integer getIdTipoFuncao() {
		return idTipoFuncao;
	}

	public void setIdTipoFuncao(Integer idTipoFuncao) {
		this.idTipoFuncao = idTipoFuncao;
	}

	public Integer getIdTipoMetodologia() {
		return idTipoMetodologia;
	}

	public void setIdTipoMetodologia(Integer idTipoMetodologia) {
		this.idTipoMetodologia = idTipoMetodologia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}