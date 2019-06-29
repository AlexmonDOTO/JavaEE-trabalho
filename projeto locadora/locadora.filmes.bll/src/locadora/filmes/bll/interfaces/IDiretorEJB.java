package locadora.filme.bll.interfaces;

import java.util.List;

import locadora.filme.bll.util.Mensagem;
import locadora.filme.dal.entidade.Diretor;

public interface IDiretorEJB {

	public Mensagem salvar(Diretor diretor);
	public Mensagem excluir(Short idDiretor);
	public List<Diretor> listar();
	
}
