package locadora.filme.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.IDiretorEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.dao.interfaces.IDiretorDAO;
import locadora.filme.dal.entidade.Diretor;

@Stateless
public class DiretorEJB implements IDiretorEJB{

	@Inject
	private IDiretorDAO diretorDAO;
	
	@Override
	public Mensagem salvar(Diretor diretor) {
		
		try {
			
			//abre a conex�o
			diretorDAO.insertOrUpdate(diretor);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
			//fecha a conex�o
		}
	}

	@Override
	public Mensagem excluir(Short idDiretor) {
		
		try {
			
			Diretor diretor = diretorDAO.findById(idDiretor);
			
			if(diretor == null) {
				throw new Exception("Diretor j� foi exclu�da.");
			}
			
			if(diretor.getNomeFilmes().size() > 0) {
				throw new Exception("Essa diretor possui nomeFilmess vinculados");
			}
			
			diretorDAO.delete(diretor);
			
			return new Mensagem("Diretor exclu�da.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Diretor> listar() {
		return diretorDAO.findAll();
	}

}
