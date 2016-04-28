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

import model.dao.ClienteDao;
import model.domain.Cliente;
import model.facade.ClienteFacade;

@Path("/cliente")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClienteFacadeImpl implements ClienteFacade {

	@Inject
	private ClienteDao clienteDao;
	
	@GET
	@Override
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}

	@GET
	@Path("/{codigo}")
	@Override
	public List<Cliente> getClientes(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigo);
		return clienteDao.getClientes(cliente);
	}
	
	@POST 
	@Override
	public Cliente salvar(Cliente cliente) { 
		cliente = clienteDao.salvar(cliente);
	 	return cliente;
	}
	
	@PUT 
	@Override
	public void atualizar(Cliente cliente) { 
		clienteDao.atualizar(cliente);
	}

	@DELETE
	@Path("/{codigo}")
	@Override
	public void deletar(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigo);
		clienteDao.excluir(cliente);
	}

}
