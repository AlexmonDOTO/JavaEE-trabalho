package locadora.filme.bll.interfaces;

import java.util.List;

import locadora.filme.bll.util.Mensagem;
import locadora.filme.dal.entidade.Filme;

public interface IFilmeEJB {

	public Mensagem salvar(Filme filme);
	public Mensagem excluir(Integer idFilme);
	public List<Filme> listar();
	public Filme obter(Integer idFilme);
	
}
