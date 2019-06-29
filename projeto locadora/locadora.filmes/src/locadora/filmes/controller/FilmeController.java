package locadora.filmes.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.filme.bll.interfaces.IFilmeEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.entidade.Filme;

@Named
@RequestScoped
public class FilmeController {

	private Filme filme;
	
	@EJB
	private IFilmeEJB filmeEJB;
	
	@Inject
	private FacesContext context;
	
	public FilmeController() {
		this.filme = new Filme();
	}
	
	public void salvar() {
		
		Mensagem msg = filmeEJB.salvar(filme);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.filme = new Filme();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Filme> todos(){
		return filmeEJB.listar();
	}
	
	public void editar(Filme filme) {
		this.filme = filme;
	}
	
	
	public void excluir(Integer idFilme) {
		
		Mensagem msg = filmeEJB.excluir(idFilme);
		
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

	
	
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
	
}
