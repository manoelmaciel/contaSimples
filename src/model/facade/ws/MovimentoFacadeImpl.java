package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MovimentoDao;
import model.domain.Movimento;
import model.facade.MovimentoFacade;

@WebService(serviceName="ws/movimento")
public class MovimentoFacadeImpl implements MovimentoFacade {
	
	@Inject
	private MovimentoDao movimentoDao;
			
	@WebMethod
	public List<Movimento> getMovimentos() {
		return movimentoDao.getMovimentos(new Movimento());
	}
	
	@Override
	@WebMethod(operationName="getMovimentoCodigo")
	public List<Movimento> getMovimentos(@WebParam(name="codigoMovimento") 
							Integer codigo) {
		Movimento movimento = new Movimento();
		movimento.setCodigoMovimento(codigo);
		return movimentoDao.getMovimentos(movimento);
	}
	
	@WebMethod
	public Movimento salvar(@WebParam(name="novoMovimento") Movimento movimento) {
		return movimentoDao.salvar(movimento);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="novoMovimento") Movimento movimento) {
		movimentoDao.atualizar(movimento);
	}
	
	@WebMethod
	public void deletar(@WebParam(name="codigoMovimento") Integer codigo) {
		Movimento movimento = new Movimento();
		movimento.setCodigoMovimento(codigo);
		movimentoDao.excluir(movimento);
	}

	@Override
	public List<Movimento> getMovimentosConta(Integer numConta) {
		// TODO Auto-generated method stub
		return null;
	}

}
