package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public void excluir(Movimento movimento) {
		// TODO Auto-generated method stub

	}

	@Override
	public Movimento salvar(Movimento movimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Movimento movimento) {
		// TODO Auto-generated method stub

	}

}
