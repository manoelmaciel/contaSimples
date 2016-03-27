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
@Table(name="TB_MOVIMENTO")
public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_MOVIMENTO")
	private Integer codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_MOVIMENTO")
	private Date data;

	@Column(name="DS_MOVIMENTO")
	private String descricao;

	@Column(name="TP_MOVIMENTO")
	private MovimentoTipoEnum tipo; // Despesa - Receita

	@Column(name="VL_MOVIMENTO")
	private Double valor;

	@ManyToOne
	@JoinColumn(name="CD_CONTA",referencedColumnName="CD_CONTA")
	private Conta conta;
	
	public Movimento() {
		// Constructor empty ... !
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentoTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(MovimentoTipoEnum tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
