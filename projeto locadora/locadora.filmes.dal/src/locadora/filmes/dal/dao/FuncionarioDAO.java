package locadora.filme.dal.dao;

import locadora.filme.dal.entidade.*;
import locadora.filme.dal.dao.interfaces.*;
import locadora.filme.dal.generics.*;
import javax.enterprise.context.*;

@RequestScoped
public class FuncionarioDAO
	extends JPAGenericDAO<Funcionario, Integer>
	implements IFuncionarioDAO{

}
