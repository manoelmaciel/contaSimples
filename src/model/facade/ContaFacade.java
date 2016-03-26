package model.facade;

import java.util.List;

import model.domain.Conta;

public interface ContaFacade {
	
	List<Conta> getContas();

	List<Conta> getContas(Integer codigo);

	Conta salvar(Conta conta);

	void atualizar(Conta conta);

	void deletar(Integer codigo);

}
