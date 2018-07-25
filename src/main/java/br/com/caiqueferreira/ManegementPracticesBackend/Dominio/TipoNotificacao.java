package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

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
@Table(name = "TipoNotificacao")
public class TipoNotificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private String Descricao;

	//@ManyToMany(mappedBy = "tipoNotificacao")
	//private List<Perfil> perfil;
	
	/*@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="TipoNotificacao_Notificacao",  
              joinColumns={@JoinColumn(name="tipoNotificacao_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="notificacao_id", 
                referencedColumnName="id")}) 
	
	private List<Notificacao> notificacaoList;
    */
	
	public TipoNotificacao() {
		super();
	}

	public TipoNotificacao(Integer id, String descricao) {
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

	/*public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	public List<Notificacao> getNotificacaoList() {
		return notificacaoList;
	}

	public void setNotificacaoList(List<Notificacao> notificacaoList) {
		this.notificacaoList = notificacaoList;
	}*/
	
	
	
}
