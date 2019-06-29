package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.IFilmeDAO;
import locadora.diurno.dal.entidade.Filme;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class FilmeDAO 
	extends JPAGenericDAO<Filme, Integer>
	implements IFilmeDAO{


	
}
