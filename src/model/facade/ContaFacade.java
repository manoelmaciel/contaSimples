package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Conta;

public interface ContaFacade {
	
	@ValidateOnExecution
	Conta salvar(@Valid Conta conta);

	List<Conta> getContas();

	List<Conta> getContas(Integer codigo);

	@ValidateOnExecution
	void atualizar(@Valid Conta conta);

	void deletar(Integer codigo);

}
