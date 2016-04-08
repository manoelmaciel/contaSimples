package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Conta;

public class ContaDaoImpl implements ContaDao {

	@PersistenceContext(unitName="ContaSimplesPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> getContas(Conta conta) {
		StringBuffer hql = new StringBuffer("from Conta c"
				+ " where 1 = 1");		
		if (conta.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (conta.getCodigo() != null) {
			query.setParameter("codigo", conta.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Conta conta) {
		conta = entityManager.merge(conta);
		entityManager.remove(conta);
	}

	@Override
	@Transactional
	public Conta salvar(Conta conta) {
		conta.setCodigo(null);
		entityManager.persist(conta);
		return conta;
	}

	@Override
	@Transactional
	public void atualizar(Conta conta) {
		conta = entityManager.merge(conta);
		entityManager.persist(conta);		
	}

}
