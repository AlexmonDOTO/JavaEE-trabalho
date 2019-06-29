package locadora.filmes.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locadora.filme.bll.interfaces.IPessoaEJB;
import locadora.filme.dal.entidade.Pessoa;

@Named
@RequestScoped
public class PessoaController {


	
	@EJB
	private IPessoaEJB pessoaEJB;

	public List<Pessoa> todos(){
		return pessoaEJB.listar();
	}
	
	
	
	
}
