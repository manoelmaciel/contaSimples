package model.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utils.MovimentoTipoEnum;

@Generated(value="Dali", date="2016-03-26T20:27:34.306-0300")
@StaticMetamodel(Movimento.class)
public class Movimento_ {
	public static volatile SingularAttribute<Movimento, Integer> codigo;
	public static volatile SingularAttribute<Movimento, Date> data;
	public static volatile SingularAttribute<Movimento, String> descricao;
	public static volatile SingularAttribute<Movimento, MovimentoTipoEnum> tipo;
	public static volatile SingularAttribute<Movimento, Double> valor;
	public static volatile SingularAttribute<Movimento, Conta> conta;
}
