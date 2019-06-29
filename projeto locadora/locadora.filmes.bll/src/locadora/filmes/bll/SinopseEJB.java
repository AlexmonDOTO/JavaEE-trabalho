package locadora.filme.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.ISinopseEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.dao.interfaces.ISinopseDAO;
import locadora.filme.dal.entidade.Sinopse;

@Stateless
public class SinopseEJB implements ISinopseEJB{

	@Inject
	private ISinopseDAO sinopseDAO;
	
	@Override
	public Mensagem salvar(Sinopse sinopse) {
		
		try {
			
			sinopseDAO.insertOrUpdate(sinopse);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idSinopse) {
		
		try {
			
			Sinopse sinopse = sinopseDAO.findById(idSinopse);
			
			if(sinopse == null) {
				throw new Exception("Sinopse já foi excluído.");
			}
			
			if(sinopse.getFilmes().size() > 0) {
				throw new Exception("Essa sinopse possui autmoveis vinculados");
			}
			
			sinopseDAO.delete(sinopse);
			
			return new Mensagem("Sinopse excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Sinopse> listar() {
		return sinopseDAO.findAll();
	}

}
