package br.com.caiqueferreira.ManegementPracticesBackend.Servico;



import org.springframework.stereotype.Service;

@Service
public class DBServico {
	/*
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private TipoMetodologiaRepositorio tipoMetodologiaRepositorio;
	
	@Autowired
	private PraticaRepositorio praticaRepositorio;

	@Autowired
	public void instantiateTestDatabase() throws ParseException {
		
		TipoMetodologia tipomet1 = new TipoMetodologia(null,"Tradicionais".toUpperCase());
	    TipoMetodologia tipomet2 = new TipoMetodologia(null,"Ageis".toUpperCase());
		TipoMetodologia tipomet3 = new TipoMetodologia(null,"3.0".toUpperCase());
		
		tipoMetodologiaRepositorio.saveAll(Arrays.asList(tipomet1,tipomet2,tipomet3));
			
		Pratica pra1 = new Pratica(null
				,"TESTE"
				,"Tem dificuldade na identificação de gargalos e pontos que merecem atenção especial nos testes do software ?"
				,"Adote a proposta de distribuir as atividades entre os integrantes do projeto,onde os lideres e gestores adotam o papel de mediador, facilitador dos problemas."
				,"MONTEIRO, Edivaldo Antonio. Utilização de técnicas ágeis em projetos exclusivos de teste de software. 2017."				
                ,tipomet1);
                
		praticaRepositorio.saveAll(Arrays.asList(pra1));
		
		Usuario lg1 = new Usuario(null, "caique ferreira","caique.sire@gmail.com",
				Funcao.GERENTE,tipomet1, pe.encode("123456"));
		lg1.addPerfil(Perfil.ADMIN);
		usuarioRepositorio.save(lg1);
		
	}
	*/
}