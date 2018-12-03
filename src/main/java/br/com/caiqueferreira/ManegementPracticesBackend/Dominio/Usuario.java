package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Funcao;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums.Perfil;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String cpfOuCnpj;

	private Integer tipoFuncao;

	@JsonIgnore
	private String senha;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIL_USUARIO")
	private Set<Integer> Perfil_ID = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "Usuario_TipoMetodologia", joinColumns = {
			@JoinColumn(name = "id_usuario") }, inverseJoinColumns = { @JoinColumn(name = "id_tipoMetodologia") })
	private List<TipoMetodologia> listaTipoMetodologia = new ArrayList<>();

	
	
	public Usuario() {
		addPerfil(Perfil.USUARIO);
	}

	public Usuario(Integer id, String nome, String email, String cpfOuCnpj, Funcao tipoFuncao, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoFuncao = (tipoFuncao == null) ? null : tipoFuncao.getCod();
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Funcao getTipoFuncao() {
		return Funcao.toEnum(tipoFuncao);
	}

	public void setTipoFuncao(Funcao funcao) {
		this.tipoFuncao = funcao.getCod();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<TipoMetodologia> getListaTipoMetodologia() {
		return listaTipoMetodologia;
	}

	public void setListaTipoMetodologia(List<TipoMetodologia> listaTipoMetodologia) {
		this.listaTipoMetodologia = listaTipoMetodologia;
	}
	
	public Set<Perfil> getPerfis() {
		return Perfil_ID.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		Perfil_ID.add(perfil.getCod());
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Email   : " + getEmail());
		builder.append("\n");
		builder.append("Senha   : " + getSenha());
		return builder.toString();
	}

	
}
