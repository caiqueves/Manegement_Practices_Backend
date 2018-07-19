package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.ResultadoAutuacao;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.ResultadoAutuacaoRepositorio;

@Service
public class ResultadoAutuacaoServico {

	@Autowired
	private ResultadoAutuacaoRepositorio resultadoAutuacaoRepositorio;

	public ResultadoAutuacao buscaPorRequisitorio(String numerorequisitorio) {
		return resultadoAutuacaoRepositorio.buscaPorRequisitorio(numerorequisitorio);
	}

	public Integer atualizarPorRequisitorio(Integer CodDocEsparta, String NumProcEsparta, String Classe, String NumProc1Grau,
			Date Dthrautuaenvio, Integer Codvara, String Vara, Integer Codcid, String Cidade, String CodUf,
			String Autuado, Date Dthrautuacao, String DescErro, String Origem, String UsuIncl, Date DthrVerif,
			String Registrado1Grau,String Numreq) {
		return resultadoAutuacaoRepositorio.atualizarPorRequisitorio(CodDocEsparta, NumProcEsparta, Classe, NumProc1Grau,
				Dthrautuaenvio, Codvara, Vara, Codcid, Cidade, CodUf, Autuado, Dthrautuacao, DescErro, Origem, UsuIncl,
				DthrVerif, Registrado1Grau,Numreq);
	}
}
