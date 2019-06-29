package locadora.filme.dal.dao.interfaces;

import java.util.Date;
import java.util.List;

import locadora.filme.dal.entidade.Locacao;
import locadora.filme.dal.generics.IGenericDAO;

public interface ILocacaoDAO
		extends IGenericDAO<Locacao,Integer>{

	List<Locacao> listar(Date data);
	List<?> listar(int ano);
}
