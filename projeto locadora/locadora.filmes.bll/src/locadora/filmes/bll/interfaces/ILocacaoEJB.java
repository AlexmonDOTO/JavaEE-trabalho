package locadora.filme.bll.interfaces;

import java.util.Date;
import java.util.List;

import locadora.filme.bll.relatorio.GraficoLinha;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.dal.entidade.Locacao;

public interface ILocacaoEJB {

	public Mensagem salvar(Locacao locacao);
	public List<Locacao> listar(Date data);
	List<GraficoLinha> listar(int ano);
}
