package locadora.filme.dal.dao;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import locadora.filme.dal.dao.interfaces.ILocacaoDAO;
import locadora.filme.dal.entidade.Locacao;
import locadora.filme.dal.generics.JPAGenericDAO;


@RequestScoped
public class LocacaoDAO 
	extends JPAGenericDAO<Locacao, Integer>
	implements ILocacaoDAO{


    public List<Locacao> listar(Date data) {
        TypedQuery<Locacao> query = em.createQuery("select a from Locacao a where a.data = :data", Locacao.class);
        query.setParameter("data", data, TemporalType.DATE);
        List<Locacao> locacoes = query.getResultList();
        return locacoes;
    }
    
    public List<?> listar(int ano) {

        Query query = super.em.createQuery("select EXTRACT(MONTH from a.locacao.data) as y,SUM(a.valor) from LocacaoFilme a "
                + "where EXTRACT(YEAR from a.locacao.data) =:ano group by y");

        query.setParameter("ano", ano);

 

        return query.getResultList();
    }

	
}