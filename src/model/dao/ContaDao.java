package model.dao;

import java.util.List;

import model.domain.Conta;

public interface ContaDao {

	List<Conta> getContas(Conta conta);
	
	public void excluir(Conta conta);

	Conta salvar(Conta conta);

	void atualizar(Conta conta);

}
