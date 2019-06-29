package locadora.filme.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.IPessoaEJB;
import locadora.filme.dal.dao.interfaces.IPessoaDAO;
import locadora.filme.dal.entidade.Pessoa;

@Stateless
public class PessoaEJB implements IPessoaEJB{

	@Inject
	private IPessoaDAO pessoaDAO;
	
	@Override
	public List<Pessoa> listar() {
		return pessoaDAO.findAll();
	}

}
