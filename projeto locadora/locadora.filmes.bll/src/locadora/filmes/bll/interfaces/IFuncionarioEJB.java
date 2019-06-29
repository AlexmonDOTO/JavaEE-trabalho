package locadora.filme.bll.interfaces;

import java.util.*;
import locadora.filme.dal.entidade.*;
import locadora.filme.bll.util.*;


public interface IFuncionarioEJB {

	public Mensagem salvar(Funcionario funcionario);
	public Mensagem excluir(Integer idPessoa);
	public List<Funcionario> listar();
	
}
