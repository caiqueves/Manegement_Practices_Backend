package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name="Perfil")
public class Perfil  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Descricao;
	
/*	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="usuario_perfil",  
              joinColumns={@JoinColumn(name="perfil_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="usuario_id", 
                referencedColumnName="id")}) */
	
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuario;
    
	
	/*@JsonIgnore
	@ManyToMany
	    @JoinTable(name = "perfil_tipoNotificacao",
	        joinColumns = @JoinColumn(name = "perfil_id"),
	        inverseJoinColumns = @JoinColumn(name = "tipoNotificacao_id")
	    )*/
	//private List<TipoNotificacao> tipoNotificacao;
	
	
	public Perfil () {}

	

	public Perfil(Integer id, String descricao, List<Usuario> usuario) {
		super();
		Id = id;
		Descricao = descricao;
		this.usuario = usuario;
	}



	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuarioList(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	/*public List<TipoNotificacao> getTipoNotificacao() {
		return tipoNotificacao;
	}

	public void setTipoNotificacao(List<TipoNotificacao> tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}*/
}
