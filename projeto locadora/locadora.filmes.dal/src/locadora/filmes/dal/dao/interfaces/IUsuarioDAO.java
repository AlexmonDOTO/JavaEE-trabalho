package locadora.filme.dal.dao.interfaces;

import locadora.filme.dal.entidade.*;
import locadora.filme.dal.generics.IGenericDAO;

public interface IUsuarioDAO 
	extends IGenericDAO<Usuario, Integer> {

	
	public Usuario porLoginSenha(String login, String senha);
	
}
