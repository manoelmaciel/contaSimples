package model.dao;

import java.util.List;

import model.domain.Cliente;

public interface ClienteDao {

	Cliente salvar(Cliente cliente);

	List<Cliente> getClientes(Cliente cliente);
	
	void atualizar(Cliente cliente);

	void excluir(Cliente cliente);

}