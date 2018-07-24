package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.LoginRepositorio;

@Service
public class LoginServico {

	@Autowired
	private LoginRepositorio  loginRepositorio;

	public void CriarLogin(
			 String Login, String Senha,
			 String Nome, String Email) {
		return;
	}
	
	public Integer FazerLogin(String Login, String Senha) {
		return loginRepositorio.FazerLogin(Login,Senha);
	}
    
	
	/*public Integer atualizarPorRequisitorio(Integer CodDocEsparta, String NumProcEsparta, String Classe, String NumProc1Grau,
			Date Dthrautuaenvio, Integer Codvara, String Vara, Integer Codcid, String Cidade, String CodUf,
			String Autuado, Date Dthrautuacao, String DescErro, String Origem, String UsuIncl, Date DthrVerif,
			String Registrado1Grau,String Numreq) {
		return resultadoAutuacaoRepositorio.atualizarPorRequisitorio(CodDocEsparta, NumProcEsparta, Classe, NumProc1Grau,
				Dthrautuaenvio, Codvara, Vara, Codcid, Cidade, CodUf, Autuado, Dthrautuacao, DescErro, Origem, UsuIncl,
				DthrVerif, Registrado1Grau,Numreq);
	}*/
    
}
