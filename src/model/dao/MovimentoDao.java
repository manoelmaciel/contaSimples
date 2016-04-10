package model.dao;

import java.util.List;

import model.domain.Movimento;

public interface MovimentoDao {

	List<Movimento> getMovimentos(Movimento movimento);
	
	void excluir(Movimento movimento);

	Movimento salvar(Movimento movimento);

	void atualizar(Movimento movimento);

}
