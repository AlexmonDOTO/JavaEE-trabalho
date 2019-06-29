package locadora.diurno.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import locadora.diurno.bll.interfaces.IFilmeEJB;
import locadora.diurno.bll.interfaces.ILocacaoEJB;
import locadora.diurno.bll.relatorio.GraficoLinha;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Locacao;
import locadora.diurno.dal.entidade.LocacaoFilme;
import locadora.diurno.util.FacesUtil;

@Named
@javax.enterprise.context.SessionScoped
public class LocacaoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ILocacaoEJB locacaoEJB;
    @EJB
    private IFilmeEJB filmeEJB;
    
    @Inject
	private FacesUtil facesUtil;
	

    private Locacao locacao;
    private LocacaoFilme locacaoFilme;
    private Integer ano;

    private LineChartModel graficoLinha;

    private List<Locacao> locacoes;

    public LocacaoController() {
        locacao = new Locacao();
        locacaoFilme = new LocacaoFilme();
    }

    public void salvar() {

        Mensagem mensagem = locacaoEJB.salvar(locacao);

        if (mensagem.getTipo() == TipoMensagem.sucesso) {
        	locacao = new Locacao();
            locacaoFilme = new LocacaoFilme();
        }
        
        facesUtil.addMessage(mensagem);
    }

    public void listar() {
        locacoes = locacaoEJB.listar(locacao.getData());
    }


    public void adicionar() {

        if (locacao.getLocacaoFilmes() == null) {
            locacao.setLocacaoFilmes(new ArrayList<>());
        }

        for (LocacaoFilme l : locacao.getLocacaoFilmes()) {
            if (Objects.equals(l.getFilme().getIdFilme(),locacaoFilme.getFilme().getIdFilme())) {
                return;
            }
        }

        locacaoFilme.setFilme(filmeEJB.obter(locacaoFilme.getFilme().getIdFilme()));
        locacao.getLocacaoFilmes().add(locacaoFilme);
        locacaoFilme = new LocacaoFilme();
    }


    public void graficoLinha() {
      
    	graficoLinha = null;
        if(ano != null) {
        	

            List<GraficoLinha> linhas = locacaoEJB.listar(ano);
            if(linhas.size() == 0) return;
            graficoLinha = new LineChartModel();
            graficoLinha.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
            graficoLinha.setLegendPosition("se");
            LineChartSeries series = new LineChartSeries();
            series.setLabel("Vendas");
            for (GraficoLinha graficoLinha : linhas) {
                series.set(graficoLinha.getMes().toString(), graficoLinha.getTotal());
            }

            graficoLinha.addSeries(series);

            graficoLinha.setLegendPosition("n");
            graficoLinha.setShowPointLabels(true);
        }

    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }


    public LocacaoFilme getLocacaoFilme() {
		return locacaoFilme;
	}

	public void setLocacaoFilme(LocacaoFilme locacaoFilme) {
		this.locacaoFilme = locacaoFilme;
	}

	public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public LineChartModel getGraficoLinha() {
        return graficoLinha;
    }

    public void setGraficoLinha(LineChartModel graficoLinha) {
        this.graficoLinha = graficoLinha;
    }

}
