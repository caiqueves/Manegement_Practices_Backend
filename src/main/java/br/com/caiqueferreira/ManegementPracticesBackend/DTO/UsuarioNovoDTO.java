package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Validacoes.UsuarioInserir;

@UsuarioInserir
public class UsuarioNovoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Por favor, informe o nome. Preenchimento obrigatório !")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório !")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Por favor, informe o Cpf Ou Cnpj. Preenchimento obrigatório !")
	private String cpfOuCnpj;

	private Integer tipoFuncao;

	@NotEmpty(message = "Por favor, informe a senha. Preenchimento obrigatório !")
	private String senha;

	private List<Integer> listaTipoMetodologia;

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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(Integer tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}

	public List<Integer> getListaTipoMetodologia() {
		return listaTipoMetodologia;
	}

	public void setListaTipoMetodologia(List<Integer> listaTipoMetodologia) {
		this.listaTipoMetodologia = listaTipoMetodologia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
