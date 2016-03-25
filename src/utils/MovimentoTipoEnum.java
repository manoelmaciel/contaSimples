package utils;

public enum MovimentoTipoEnum {
	
	DESPESA("Despesa"), RECEITA("Receita");

	private String movimentoTipo;

	MovimentoTipoEnum(String movimentoTipo) {
		this.movimentoTipo = movimentoTipo;
	}

	public String getTipo() {
		return movimentoTipo;
	}

}
