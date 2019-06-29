package locadora.filme.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.filme.dal.dao.interfaces.ISinopseDAO;
import locadora.filme.dal.entidade.Sinopse;
import locadora.filme.dal.generics.JPAGenericDAO;

@RequestScoped
public class SinopseDAO 
	extends JPAGenericDAO<Sinopse, Short>
	implements ISinopseDAO{


	
}
