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

import model.dao.ContaDao;
import model.domain.Conta;
import model.facade.ContaFacade;

@Path("/conta")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ContaFacadeImpl implements ContaFacade {

	@Inject
	private ContaDao contaDao;
	
	@GET
	@Override
	public List<Conta> getContas() {
		return contaDao.getContas(new Conta());
	}

	
	@GET
	@Path("/{codigo}")
	@Override
	public List<Conta> getContas(@PathParam("codigo") Integer codigo) {
		Conta conta = new Conta();
		conta.setCodigoConta(codigo);
		return contaDao.getContas(conta);
	}
	
	@POST
	@Override
	public Conta salvar(Conta conta) {
		conta = contaDao.salvar(conta);
	 	return conta;
	}

	@PUT
	@Override
	public void atualizar(Conta conta) {
		contaDao.atualizar(conta);
	}

	@DELETE
	@Path("/{codigo}")
	@Override
	public void deletar(@PathParam("codigo") Integer codigo) {
		Conta conta = new Conta();
		conta.setCodigoConta(codigo);
		contaDao.excluir(conta);
	}

}
