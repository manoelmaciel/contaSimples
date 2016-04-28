package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
	@PersistenceContext(unitName="contaSimplesPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(Cliente cliente) {
		StringBuffer hql = new StringBuffer("from Cliente c"
				+ " where 1 = 1");		
		if (cliente.getCodigoCliente() != null) {
			hql.append(" and c.codigoCliente = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (cliente.getCodigoCliente() != null) {
			query.setParameter("codigo", cliente.getCodigoCliente());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Cliente cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.remove(cliente);
	}

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		cliente.setCodigoCliente(null);
		entityManager.persist(cliente);
		return cliente;
	}

	@Override
	@Transactional
	public void atualizar(Cliente cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.persist(cliente);		
	}
	
}
