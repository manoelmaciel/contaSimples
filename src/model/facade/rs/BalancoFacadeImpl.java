package model.facade.rs;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.BalancoDao;
import model.domain.Movimento;
import model.facade.BalancoFacade;

@Path("/balanco")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BalancoFacadeImpl implements BalancoFacade {

	@Inject
	private BalancoDao balancoDao;
	
	@GET
	@Override
	public List<Movimento> balanco() {
		// TODO Testando o o balanço simples ... Só teste!
		return balancoDao.balanco();
	}

	@Override
	public List<Movimento> balancoMensal(Date mesAno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimento> balancoAnual(Date ano) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Movimento> balancoPeriodico(Date inicio, Date fim) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public List<Movimento> balancoGeral() {
		// TODO Auto-generated method stub
		return null;
	}

}
