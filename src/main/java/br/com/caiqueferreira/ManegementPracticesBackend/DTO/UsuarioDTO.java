package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public class UsuarioDTO {

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotNull
	private Integer tipoFuncao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
    
	
	private List<Integer> listaTipoMetodologia;
	
	public UsuarioDTO() {}

	public UsuarioDTO(Usuario obj) 
	{	
		id = obj.getId();
		nome = obj.getNome();
		senha = obj.getSenha();
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

	public Integer getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(Integer tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Integer> getListaTipoMetodologia() {
		return listaTipoMetodologia;
	}

	public void setListaTipoMetodologia(List<Integer> listaTipoMetodologia) {
		this.listaTipoMetodologia = listaTipoMetodologia;
	}
}
