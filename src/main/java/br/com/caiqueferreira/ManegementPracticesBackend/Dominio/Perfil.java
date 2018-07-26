package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Perfil")
public class Perfil  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Descricao;
		
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuario;
    
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="perfil_tiponotificacao",  
              joinColumns={@JoinColumn(name="perfil_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="tiponotificacao_id", 
                referencedColumnName="id")}) 
	private List<TipoNotificacao> listipoNotificacao;
	
	
	public Perfil () {}

	

	public Perfil(Integer id, String descricao) {
		super();
		Id = id;
		Descricao = descricao;
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
