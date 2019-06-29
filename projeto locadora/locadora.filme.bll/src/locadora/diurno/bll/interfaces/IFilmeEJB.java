package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Filme;

public interface IFilmeEJB {

	public Mensagem salvar(Filme filme);
	public Mensagem excluir(Integer idFilme);
	public List<Filme> listar();
	public Filme obter(Integer idFilme);
	
}
