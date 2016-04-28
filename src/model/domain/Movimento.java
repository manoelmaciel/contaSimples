package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import utils.MovimentoTipoEnum;

@XmlRootElement
@Entity
@Table(name="MOVIMENTOS")
public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMovimento")
	private Integer codigoMovimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtMovimento")
	private Date dataMovimento;

	@Column(name="descMovimento")
	private String descricaoMovimento;

	@Column(name="tpMovimento")
	private MovimentoTipoEnum tipoMovimento; // Despesa - Receita

	@Column(name="vlMovimento")
	private Double valorMovimento;

	@ManyToOne
	@JoinColumn(name="conta",referencedColumnName="idConta")
	private Conta conta;

	public Integer getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(Integer codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getDescricaoMovimento() {
		return descricaoMovimento;
	}

	public void setDescricaoMovimento(String descricaoMovimento) {
		this.descricaoMovimento = descricaoMovimento;
	}

	public MovimentoTipoEnum getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(MovimentoTipoEnum tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Double getValorMovimento() {
		return valorMovimento;
	}

	public void setValorMovimento(Double valorMovimento) {
		this.valorMovimento = valorMovimento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoMovimento == null) ? 0 : codigoMovimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		if (codigoMovimento == null) {
			if (other.codigoMovimento != null)
				return false;
		} else if (!codigoMovimento.equals(other.codigoMovimento))
			return false;
		return true;
	}
	
}
