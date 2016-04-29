package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Conta;
import model.domain.Movimento;

public class MovimentoDaoImpl implements MovimentoDao {

	@PersistenceContext(unitName="contaSimplesPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimento> getMovimentos(Movimento movimento) {
		StringBuffer hql = new StringBuffer("from Movimento m "
				+ "where 1 = 1");		
		if (movimento.getCodigoMovimento() != null) {
			hql.append(" and m.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (movimento.getCodigoMovimento() != null) {
			query.setParameter("codigo", movimento.getDataMovimento());
		} 
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movimento> getMovimentosConta(Conta conta) {
		StringBuffer hql = new StringBuffer("from Movimento m "
				+ "where 1 = 1");		
		if (conta.getCodigoConta() != null) {
			hql.append(" and m.conta = :umaConta");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (conta.getCodigoConta() != null) {
			query.setParameter("umaConta", conta);
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
		movimento.setCodigoMovimento(null);
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
