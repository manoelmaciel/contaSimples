package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Movimento;

public interface MovimentoFacade {

	List<Movimento> getMovimentos();

	List<Movimento> getMovimentos(Integer codigo);

	@ValidateOnExecution
	Movimento salvar(@Valid Movimento movimento);

	@ValidateOnExecution
	void atualizar(@Valid Movimento movimento);

	void deletar(Integer codigo);

	List<Movimento> getMovimentosConta(Integer numConta);

}
