package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ResultadoAutuacao" )
public class ResultadoAutuacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false, updatable=false)
	private String NUMREQ;
	
	@Column(name="CODDOCESPARTA")
	private Integer CodDocEsparta;
	
	@Column(name="NUMPROCESPARTA")
	private String NumProcEsparta;
	
	@Column(name="CLASSE")
	private String Classe;
	
	@Column(name="NUMPROC1GRAU")
	private String NumProc1Grau;
	
	@Column(name="DTHRAUTUAENVIO")
	private Date Dthrautuaenvio;
	
	@Column(name="CODVARA")
	private Integer Codvara;
	
	@Column(name="VARA")
	private  String Vara;           
	
	@Column(name="CODCID")
	private  Integer Codcid;        
	
	@Column(name="CIDADE")
	private  String Cidade;           
	
	@Column(name="CODUF")
	private  String CodUf;            
	
	@Column(name="AUTUADO")
	private  String Autuado;         
	
	@Column(name="DTHRAUTUACAO")
	private  Date Dthrautuacao;   
	
	@Column(name="DESCRERRO")
	private  String DescErro;        
	
	@Column(name="ORIGEM")
	private  String Origem;           
	
	@Column(name="USUINCL")
	private  String UsuIncl;          
	
	@Column(name="DTHRVERIF")
	private  Date DthrVerif;        
	
	@Column(name="REGISTRADO1GRAU")
	private  String Registrado1Grau;
	
	public ResultadoAutuacao () {}

	
	public String getNUMREQ() {
		return NUMREQ;
	}

	public void setNUMREQ(String nUMREQ) {
		NUMREQ = nUMREQ;
	}

	public Integer getCodDocEsparta() {
		return CodDocEsparta;
	}

	public void setCodDocEsparta(Integer codDocEsparta) {
		CodDocEsparta = codDocEsparta;
	}

	public String getNumProcEsparta() {
		return NumProcEsparta;
	}

	public void setNumProcEsparta(String numProcEsparta) {
		NumProcEsparta = numProcEsparta;
	}

	public String getClasse() {
		return Classe;
	}

	public void setClasse(String classe) {
		Classe = classe;
	}

	public String getNumProc1Grau() {
		return NumProc1Grau;
	}

	public void setNumProc1Grau(String numProc1Grau) {
		NumProc1Grau = numProc1Grau;
	}

	public Date getDthrautuaenvio() {
		return Dthrautuaenvio;
	}

	public void setDthrautuaenvio(Date dthrautuaenvio) {
		Dthrautuaenvio = dthrautuaenvio;
	}

	public Integer getCodvara() {
		return Codvara;
	}

	public void setCodvara(Integer codvara) {
		Codvara = codvara;
	}

	public String getVara() {
		return Vara;
	}

	public void setVara(String vara) {
		Vara = vara;
	}

	public Integer getCodcid() {
		return Codcid;
	}

	public void setCodcid(Integer codcid) {
		Codcid = codcid;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getCodUf() {
		return CodUf;
	}

	public void setCodUf(String codUf) {
		CodUf = codUf;
	}

	public String getAutuado() {
		return Autuado;
	}

	public void setAutuado(String autuado) {
		Autuado = autuado;
	}

	public Date getDthrautuacao() {
		return Dthrautuacao;
	}

	public void setDthrautuacao(Date dthrautuacao) {
		Dthrautuacao = dthrautuacao;
	}

	public String getDescErro() {
		return DescErro;
	}

	public void setDescErro(String descErro) {
		DescErro = descErro;
	}

	public String getOrigem() {
		return Origem;
	}

	public void setOrigem(String origem) {
		Origem = origem;
	}

	public String getUsuIncl() {
		return UsuIncl;
	}

	public void setUsuIncl(String usuIncl) {
		UsuIncl = usuIncl;
	}

	public Date getDthrVerif() {
		return DthrVerif;
	}

	public void setDthrVerif(Date dthrVerif) {
		DthrVerif = dthrVerif;
	}

	public String getRegistrado1Grau() {
		return Registrado1Grau;
	}

	public void setRegistrado1Grau(String registrado1Grau) {
		Registrado1Grau = registrado1Grau;
	}
	
	
	
}
