package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Movimento;

public class MovimentoDaoImpl implements MovimentoDao {

	@PersistenceContext(unitName="ContaSimplesPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimento> getMovimentos(Movimento movimento) {
		StringBuffer hql = new StringBuffer("from Movimento c"
				+ " where 1 = 1");		
		if (movimento.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (movimento.getCodigo() != null) {
			query.setParameter("codigo", movimento.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Movimento movimento) {
		movimento = entityManager.merge(movimento);
		entityManager.remove(movimento);
	}

	@Override
	@Transactional
	public Movimento salvar(Movimento movimento) {
		movimento.setCodigo(null);
		entityManager.persist(movimento);
		return movimento;
	}

	@Override
	@Transactional
	public void atualizar(Movimento movimento) {
		movimento = entityManager.merge(movimento);
		entityManager.persist(movimento);
	}

}
