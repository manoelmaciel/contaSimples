package model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="CONTAS")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idConta")
	private Integer codigoConta;
	
	// @NotNull(message="O campo nome é obrigatório ... !")
	// @Size(min=5,message="O nome do cliente precisa ter pelo menos 5 caracteres ... !")
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente",referencedColumnName="idCliente")
	private Cliente cliente;

	public Integer getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(Integer codigoConta) {
		this.codigoConta = codigoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	// @XmlTransient
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoConta == null) ? 0 : codigoConta.hashCode());
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
		Conta other = (Conta) obj;
		if (codigoConta == null) {
			if (other.codigoConta != null)
				return false;
		} else if (!codigoConta.equals(other.codigoConta))
			return false;
		return true;
	}
	
}
