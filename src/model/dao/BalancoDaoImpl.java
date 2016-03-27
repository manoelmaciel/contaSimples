package model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.Movimento;

public class BalancoDaoImpl implements BalancoDao {

	@PersistenceContext(unitName="ContaSimplesPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<Movimento> balancoMensal(Date mesAno) {
		// TODO Falta concluir o balanço mensal ... !
		StringBuffer hql = new StringBuffer("from Movimento c"
				+ " where c.dt_movimento = 0");		
		Query query = entityManager.createQuery(hql.toString());
		return query.getResultList();
	}

	@Override
	public List<Movimento> balancoAnual(Date ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimento> balancoPeriodico(Date inicio, Date fim) {
		// TODO Falta implementar o balanço periódico ... !
		return null;

	}

	@Override
	public List<Movimento> balancoGeral() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Movimento> balanco() {
		// TODO Tentando implementar um teste de balanço ... !
		// Calendar c = Calendar.getInstance(); 
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM); 
		Date data1 = null;
		Date data2 = null;
		try {
			data1 = f.parse("15/01/2016");
			data2 = f.parse("25/02/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuffer hql = new StringBuffer("from Movimento c" 
				+ " where 1 = 1 and c.data > :dtMov1 and c.data < :dtMov2");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("dtMov1", data1);
		query.setParameter("dtMov2", data2);
		return query.getResultList();

	}

}
