package locadora.filme.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import locadora.filme.dal.dao.interfaces.INomeFilmeDAO;
import locadora.filme.dal.entidade.NomeFilme;
import locadora.filme.dal.generics.JPAGenericDAO;

@RequestScoped
public class NomeFilmeDAO
		extends JPAGenericDAO<NomeFilme, Short>
		implements INomeFilmeDAO {

	@Override
	public List<NomeFilme> findByDiretor(String nomeDiretor) {
		
		TypedQuery<NomeFilme> query =
					em.createQuery("select m from NomeFilme as m where m.diretor.descricao = :nomeDiretor order by m.diretor.descricao",NomeFilme.class);
		
		query.setParameter("nomeDiretor", nomeDiretor);
		
		return query.getResultList();
	}

	
}
