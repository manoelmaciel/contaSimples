package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.MovimentoDao;
import model.domain.Movimento;

@Path("/movimento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MovimentoFacadeImpl implements model.facade.MovimentoFacade {

	@Inject
	private MovimentoDao contaDao;
	
	@GET
	@Override
	public List<Movimento> getMovimentos() {
		return contaDao.getMovimentos(new Movimento());
	}

	@Override
	public List<Movimento> getMovimentos(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void deletar(Integer codigo) {
		// TODO Auto-generated method stub

	}

}
