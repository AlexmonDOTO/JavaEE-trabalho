package locadora.filme.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.filme.dal.dao.interfaces.IDiretorDAO;
import locadora.filme.dal.entidade.Diretor;
import locadora.filme.dal.generics.JPAGenericDAO;

@RequestScoped
public class DiretorDAO 
	extends JPAGenericDAO<Diretor, Short>
	implements IDiretorDAO{


	
}
