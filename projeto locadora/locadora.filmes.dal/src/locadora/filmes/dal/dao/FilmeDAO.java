package locadora.filme.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.filme.dal.dao.interfaces.IFilmeDAO;
import locadora.filme.dal.entidade.Filme;
import locadora.filme.dal.generics.JPAGenericDAO;

@RequestScoped
public class FilmeDAO 
	extends JPAGenericDAO<Filme, Integer>
	implements IFilmeDAO{


	
}
