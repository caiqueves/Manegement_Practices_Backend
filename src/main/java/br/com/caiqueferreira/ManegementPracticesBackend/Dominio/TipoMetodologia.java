package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TipoMetodologia")
public class TipoMetodologia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String descricao;

	@JsonIgnore
	
	@OneToMany
    @JoinColumn(name = "tipoMetodologia_id") // Esta coluna está na tabela "usuario".
    private List<Usuario> usuario;
	
	/*
	@ManyToMany(mappedBy = "listaTipoMetodologia")
	private List<Usuario> usuarios = new ArrayList<>();
    */
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoMetodologia", cascade = CascadeType.ALL)
	private List<Pratica> praticas = new ArrayList<>();

	public TipoMetodologia() {

	}

	public TipoMetodologia(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
	
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Pratica> getPraticas() {
		return praticas;
	}

	public void setPraticas(List<Pratica> praticas) {
		this.praticas = praticas;
	}
}
