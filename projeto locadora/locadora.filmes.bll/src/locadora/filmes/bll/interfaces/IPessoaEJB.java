package locadora.filme.bll.interfaces;

import java.util.List;

import locadora.filme.dal.entidade.Pessoa;

public interface IPessoaEJB {

	public List<Pessoa> listar();
	
}
