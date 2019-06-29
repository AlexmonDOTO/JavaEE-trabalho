package locadora.filme.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.filme.bll.interfaces.ILocacaoEJB;
import locadora.filme.bll.relatorio.GraficoLinha;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.dao.interfaces.ILocacaoDAO;
import locadora.filme.dal.entidade.Locacao;
import locadora.filme.dal.entidade.LocacaoFilme;

@Stateless
public class LocacaoEJB implements ILocacaoEJB{

	@Inject
	private ILocacaoDAO locadoraDAO;
	
    @Override
    public Mensagem salvar(Locacao locacao) {
        try {
            for (LocacaoFilme lv : locacao.getLocacaoFilmes()) {
                lv.setLocacao(locacao);
            }

            locadoraDAO.insertOrUpdate(locacao);
            return new Mensagem("Locação salva.",
					TipoMensagem.sucesso);
        } catch (Exception ex) {
        	return new Mensagem(ex.getMessage(), TipoMensagem.erro);
        }
    }

    public List<Locacao> listar(Date data) {
        return locadoraDAO.listar(data);
    }
    
    
    public List<GraficoLinha> listar(int ano) {

        List<GraficoLinha> locacoes = new ArrayList<>();

		List<?> list =  locadoraDAO.listar(ano);
		
		for (Object object : list) {
			Object[] objects = (Object[])object;
			locacoes.add(new GraficoLinha((Integer) objects[0], (Double) objects[1]));
		}

        return locacoes;
    }
}
