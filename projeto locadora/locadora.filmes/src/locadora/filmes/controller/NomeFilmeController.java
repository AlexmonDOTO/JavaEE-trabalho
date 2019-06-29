package locadora.filmes.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.filme.bll.interfaces.INomeFilmeEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.entidade.NomeFilme;

@Named
@RequestScoped
public class NomeFilmeController {

	private NomeFilme nomeFilmes;
	
	@EJB
	private INomeFilmeEJB nomeFilmesEJB;
	
	@Inject
	private FacesContext context;
	
	public NomeFilmeController() {
		this.nomeFilmes = new NomeFilme();
	}
	
	public void salvar() {
		
		Mensagem msg = nomeFilmesEJB.salvar(nomeFilmes);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.nomeFilmes = new NomeFilme();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	public List<NomeFilme> todos(){
		return nomeFilmesEJB.listar();
	}
	
	public void editar(NomeFilme nomeFilmes) {
		this.nomeFilmes = nomeFilmes;
	}
	
	
	public void excluir(Short idNomeFilme) {
		
		Mensagem msg = nomeFilmesEJB.excluir(idNomeFilme);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	
	
	
	public NomeFilme getNomeFilme() {
		return nomeFilmes;
	}

	public void setNomeFilme(NomeFilme nomeFilmes) {
		this.nomeFilmes = nomeFilmes;
	}
	
	
	
}
