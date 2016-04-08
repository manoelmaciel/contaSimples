package model.dao;

import java.util.List;

import model.domain.Conta;

public interface ContaDao {

	Conta salvar(Conta conta);

	List<Conta> getContas(Conta conta);
	
	void atualizar(Conta conta);

	void excluir(Conta conta);

}
