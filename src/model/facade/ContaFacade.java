package model.facade;

import java.util.List;

import model.domain.Conta;

public interface ContaFacade {
	
	Conta salvar(Conta conta);

	List<Conta> getContas();

	List<Conta> getContas(Integer codigo);

	void atualizar(Conta conta);

	void deletar(Integer codigo);

}
