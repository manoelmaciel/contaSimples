package model.facade;

import java.util.Date;
import java.util.List;

import model.domain.Movimento;

public interface BalancoFacade {
	
	List<Movimento> balanco();	
	
	List<Movimento> balancoMensal(Date mesAno);

	List<Movimento> balancoAnual(Date ano);

	List<Movimento> balancoPeriodico(Date inicio, Date fim);

	List<Movimento> balancoGeral();

}
