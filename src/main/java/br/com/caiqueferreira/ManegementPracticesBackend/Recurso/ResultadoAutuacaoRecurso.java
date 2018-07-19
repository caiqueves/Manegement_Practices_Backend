package br.com.caiqueferreira.ManegementPracticesBackend.Recurso;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.ResultadoAutuacaoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.ResultadoAutuacao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.ResultadoAutuacaoServico;

@RestController
@RequestMapping(value = "/requisitorio")
public class ResultadoAutuacaoRecurso {
 
	@Autowired
	private  ResultadoAutuacaoServico resultadoAutuacaoServico;
	
	@RequestMapping(value = "/buscar/{numreq}",method = RequestMethod.GET)
	public ResponseEntity<ResultadoAutuacaoDTO> buscarRequisitorio(@PathVariable String numreq) {
		
		ResultadoAutuacaoDTO rstAutuacaoDTO = retornoAutuacao(numreq);
		return ResponseEntity.ok().body(rstAutuacaoDTO);
	}
     
	private ResultadoAutuacaoDTO retornoAutuacao(String requisitorio) {
		
		ResultadoAutuacaoDTO rstAutuacaoDTO = new ResultadoAutuacaoDTO();
		ResultadoAutuacao rstAutuacao = resultadoAutuacaoServico.buscaPorRequisitorio(requisitorio);
		
		rstAutuacaoDTO.setNumReq(rstAutuacao.getNUMREQ());
		rstAutuacaoDTO.setCodDocEsparta(rstAutuacao.getCodDocEsparta());
		rstAutuacaoDTO.setNumProcEsparta(rstAutuacao.getNumProcEsparta());
		rstAutuacaoDTO.setClasse(rstAutuacao.getClasse());
		rstAutuacao.setNumProc1Grau(rstAutuacao.getNumProc1Grau());
		rstAutuacaoDTO.setDthrautuaenvio(rstAutuacao.getDthrautuaenvio());
		rstAutuacaoDTO.setCodvara(rstAutuacao.getCodvara());
		rstAutuacaoDTO.setVara(rstAutuacao.getVara());
		rstAutuacaoDTO.setCodcid(rstAutuacao.getCodcid());
		rstAutuacaoDTO.setCidade(rstAutuacao.getCidade());
		rstAutuacaoDTO.setCodUf(rstAutuacao.getCodUf());
		rstAutuacaoDTO.setAutuado(rstAutuacao.getAutuado());
		rstAutuacaoDTO.setDthrautuacao(rstAutuacao.getDthrautuacao());
		rstAutuacaoDTO.setDescErro(rstAutuacao.getDescErro());
		rstAutuacaoDTO.setOrigem(rstAutuacao.getOrigem());
		rstAutuacaoDTO.setUsuIncl(rstAutuacao.getUsuIncl());
		rstAutuacaoDTO.setDthrVerif(rstAutuacao.getDthrVerif());
		
		return rstAutuacaoDTO;
	}
    
	
	
	@RequestMapping(value = "/Atualizar/{Numreq}", method = RequestMethod.PUT)
	public ResponseEntity<Integer> criarUsuario(@Valid @RequestBody ResultadoAutuacaoDTO resultadoAutuacaoDto, @PathVariable String Numreq) {
		Integer retorno = 0;
		try {
			retorno = resultadoAutuacaoServico.atualizarPorRequisitorio(resultadoAutuacaoDto.getCodDocEsparta(),
			resultadoAutuacaoDto.getNumProcEsparta(),
			resultadoAutuacaoDto.getClasse(),
			resultadoAutuacaoDto.getNumProc1Grau(),
			resultadoAutuacaoDto.getDthrautuaenvio(),
			resultadoAutuacaoDto.getCodvara(),
			resultadoAutuacaoDto.getVara(),
			resultadoAutuacaoDto.getCodcid(),
			resultadoAutuacaoDto.getCidade(),
			resultadoAutuacaoDto.getCodUf(),
			resultadoAutuacaoDto.getAutuado(),
			resultadoAutuacaoDto.getDthrautuacao(),
			resultadoAutuacaoDto.getDescErro(),
			resultadoAutuacaoDto.getOrigem(),
			resultadoAutuacaoDto.getUsuIncl(),
			resultadoAutuacaoDto.getDthrVerif(),
			resultadoAutuacaoDto.getRegistrado1Grau(),
			Numreq);
			
		}catch(Exception e) {
			
		}
		return ResponseEntity.ok().body(retorno);
	}
}
