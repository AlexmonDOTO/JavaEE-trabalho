package locadora.filme.bll.interfaces;

import java.util.List;

import locadora.filme.bll.util.Mensagem;
import locadora.filme.dal.entidade.Sinopse;

public interface ISinopseEJB {

	public Mensagem salvar(Sinopse sinopse);
	public Mensagem excluir(Short idSinopse);
	public List<Sinopse> listar();
	
}
