package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(value = {"numreq", "coddocesparta", "numprocesparta", "classe", "numproc1grau", 
		"dthrautuaenvio", "codvara", "vara", "codcid", "cidade","codUf","autuado","dthrautuacao","descerro",
		"origem","usuincl","dthrverif","registrado1grau"})
public class ResultadoAutuacaoDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	private String NumReq;
	
	@NotNull
	private Integer CodDocEsparta;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String NumProcEsparta;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String Classe;
	
	
	private String NumProc1Grau;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date Dthrautuaenvio;
	
	@NotNull
	private Integer Codvara;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String Vara;           
	
	@NotNull
	private  Integer Codcid;        
	
	@NotEmpty(message="Descrição da cidade, Obrigatória!")
	private  String Cidade;           
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String CodUf;            
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String Autuado;         
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private  Date Dthrautuacao;   
	
    
	private  String DescErro;        
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String Origem;           
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String UsuIncl;          
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private  Date DthrVerif;        
	
	@NotEmpty(message="Preenchimento obrigatório")
	private  String Registrado1Grau;

	
	public ResultadoAutuacaoDTO() {}
	
	public String getNumReq() {
		return NumReq;
	}

	public void setNumReq(String numReq) {
		NumReq = numReq;
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
