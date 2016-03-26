package model.facade;

import java.util.List;

import model.domain.Movimento;

public interface MovimentoFacade {

	List<Movimento> getMovimentos();

	List<Movimento> getMovimentos(Integer codigo);

	Movimento salvar(Movimento movimento);

	void atualizar(Movimento movimento);

	void deletar(Integer codigo);

}
