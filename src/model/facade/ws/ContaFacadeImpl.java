package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ContaDao;
import model.domain.Conta;
import model.facade.ContaFacade;

@WebService(serviceName="ws/conta")
public class ContaFacadeImpl implements ContaFacade {
	
	@Inject
	private ContaDao contaDao;
			
	@WebMethod
	public List<Conta> getContas() {
		return contaDao.getContas(new Conta());
	}
	
	@Override
	@WebMethod(operationName="getContaCodigo")
	public List<Conta> getContas(@WebParam(name="codigoConta") 
							Integer codigo) {
		Conta conta = new Conta();
		conta.setCodigo(codigo);
		return contaDao.getContas(conta);
	}
	
	@WebMethod
	public Conta salvar(@WebParam(name="novoConta") Conta conta) {
		return contaDao.salvar(conta);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="novoConta") Conta conta) {
		contaDao.atualizar(conta);
	}
	
	@WebMethod
	public void deletar(@WebParam(name="codigoConta") Integer codigo) {
		Conta conta = new Conta();
		conta.setCodigo(codigo);
		contaDao.excluir(conta);
	}

}
