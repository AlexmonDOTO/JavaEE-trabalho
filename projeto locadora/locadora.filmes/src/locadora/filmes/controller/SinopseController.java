package locadora.filmes.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.filme.bll.interfaces.ISinopseEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.entidade.Sinopse;

@Named
@RequestScoped
public class SinopseController {

	private Sinopse sinopse;
	
	@EJB
	private ISinopseEJB sinopseEJB;
	
	@Inject
	private FacesContext context;
	
	public SinopseController() {
		this.sinopse = new Sinopse();
	}
	
	public void salvar() {
		
		Mensagem msg = sinopseEJB.salvar(sinopse);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.sinopse = new Sinopse();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Sinopse> todos(){
		return sinopseEJB.listar();
	}
	
	public void editar(Sinopse sinopse) {
		this.sinopse = sinopse;
	}
	
	
	public void excluir(Short idSinopse) {
		
		Mensagem msg = sinopseEJB.excluir(idSinopse);
		
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

	
	
	
	public Sinopse getSinopse() {
		return sinopse;
	}

	public void setSinopse(Sinopse sinopse) {
		this.sinopse = sinopse;
	}
	
	
	
}
