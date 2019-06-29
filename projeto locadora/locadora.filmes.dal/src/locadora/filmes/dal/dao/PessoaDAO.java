package locadora.filme.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.filme.dal.dao.interfaces.IPessoaDAO;
import locadora.filme.dal.entidade.Pessoa;
import locadora.filme.dal.generics.JPAGenericDAO;

@RequestScoped
public class PessoaDAO 
	extends JPAGenericDAO<Pessoa, Integer>
	implements IPessoaDAO{


	
}
