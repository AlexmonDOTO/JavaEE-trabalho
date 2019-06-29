package locadora.filmes.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.filme.bll.interfaces.IDiretorEJB;
import locadora.filme.bll.util.Mensagem;
import locadora.filme.bll.util.TipoMensagem;
import locadora.filme.dal.entidade.Diretor;

@Named
@RequestScoped
public class DiretorController {

	private Diretor diretor;
	
	@EJB
	private IDiretorEJB diretorEJB;
	
	@Inject
	private FacesContext context;
	
	public DiretorController() {
		this.diretor = new Diretor();
	}
	
	public void salvar() {
		
		Mensagem msg = diretorEJB.salvar(diretor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.diretor = new Diretor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Diretor> todos(){
		return diretorEJB.listar();
	}
	
	public void editar(Diretor diretor) {
		this.diretor = diretor;
	}
	
	
	public void excluir(Short idDiretor) {
		
		Mensagem msg = diretorEJB.excluir(idDiretor);
		
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

	
	
	
	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	
	
	
}
