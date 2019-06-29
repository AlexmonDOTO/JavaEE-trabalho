package locadora.filme.bll.interfaces;

import java.util.List;

import locadora.filme.bll.util.Mensagem;
import locadora.filme.dal.entidade.NomeFilme;

public interface INomeFilmeEJB {

	public Mensagem salvar(NomeFilme nomeFilmes);
	public Mensagem excluir(Short idNomeFilme);
	public List<NomeFilme> listar();
}
