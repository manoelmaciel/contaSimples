package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.MovimentoDao;
import model.domain.Conta;
import model.domain.Movimento;

@Path("/movimento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MovimentoFacadeImpl implements model.facade.MovimentoFacade {

	@Inject
	private MovimentoDao movimentoDao;
	
	@GET
	@Override
	public List<Movimento> getMovimentos() {
		return movimentoDao.getMovimentos(new Movimento());
	}

	@GET
	@Path("/{codigo}")
	@Override
	public List<Movimento> getMovimentos(@PathParam("codigo") Integer codigo) {
		Movimento movimento = new Movimento();
		movimento.setCodigoMovimento(codigo);
		return movimentoDao.getMovimentos(movimento);
	}

	@GET
	@Path("conta/{numConta}")
	@Override
	public List<Movimento> getMovimentosConta(@PathParam("numConta") Integer numConta) {
		Conta conta = new Conta();
		conta.setCodigoConta(numConta);
		return movimentoDao.getMovimentosConta(conta);
	}

	@POST
	@Override
	public Movimento salvar(Movimento movimento) {
		movimentoDao.salvar(movimento);
		return movimento;
	}

	@PUT
	@Override
	public void atualizar(Movimento movimento) {
		movimentoDao.atualizar(movimento);
	}

	@DELETE
	@Path("/{codigo}")
	@Override
	public void deletar(@PathParam("codigo") Integer codigo) {
		Movimento movimento = new Movimento();
		movimento.setCodigoMovimento(codigo);
		movimentoDao.excluir(movimento);
	}

}
