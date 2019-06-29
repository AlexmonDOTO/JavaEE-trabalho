package locadora.filme.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.INomeFilmeEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.dao.interfaces.INomeFilmeDAO;
import locadora.filme.dal.entidade.NomeFilme;


@Stateless
public class NomeFilmeEJB implements INomeFilmeEJB {

	@Inject
	private INomeFilmeDAO nomeFilmesDAO;
	
	@Override
	public Mensagem salvar(NomeFilme nomeFilmes) {

		try {
			nomeFilmesDAO.insertOrUpdate(nomeFilmes);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
	}

	@Override
	public Mensagem excluir(Short idNomeFilme) {
		
		
		try {
			
			NomeFilme nomeFilmes = nomeFilmesDAO.findById(idNomeFilme);
			
			if(nomeFilmes == null) {
				throw new Exception("NomeFilme inexistente.");
			}
			
			if(nomeFilmes.getFilmes().size() > 0) {
				throw new Exception("Existem filmes vinculados a essa diretor");
			}
			
			nomeFilmesDAO.delete(nomeFilmes);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				TipoMensagem.sucesso);
		
	}


	@Override
	public List<NomeFilme> listar() {
		return nomeFilmesDAO.findAll();
	}

}
