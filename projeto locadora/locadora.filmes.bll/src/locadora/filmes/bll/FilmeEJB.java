package locadora.filme.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.IFilmeEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.dao.interfaces.IFilmeDAO;
import locadora.filme.dal.entidade.Filme;

@Stateless
public class FilmeEJB implements IFilmeEJB{

	@Inject
	private IFilmeDAO filmeDAO;
	
	@Override
	public Mensagem salvar(Filme filme) {
		
		try {
		
			filmeDAO.insertOrUpdate(filme);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idFilme) {
		
		try {
			
			Filme filme = filmeDAO.findById(idFilme);
			
			if(filme == null) {
				throw new Exception("Filme já foi excluído.");
			}
			
	
			
			filmeDAO.delete(filme);
			
			return new Mensagem("Filme excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Filme> listar() {
		return filmeDAO.findAll();
	}

	@Override
	public Filme obter(Integer idFilme) {
		// TODO Auto-generated method stub
		return filmeDAO.findById(idFilme);
	}

}
