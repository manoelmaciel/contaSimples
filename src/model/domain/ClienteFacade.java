package model.domain;

import java.util.List;

public interface ClienteFacade {

	List<Cliente> getClientes();

	List<Cliente> getClientes(Integer codigo);

	Cliente salvar(Cliente cliente);

	void atualizar(Cliente cliente);

	void deletar(Integer codigo);

}