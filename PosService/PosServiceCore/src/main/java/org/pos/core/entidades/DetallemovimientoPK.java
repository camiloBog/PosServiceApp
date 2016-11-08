package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The primary key class for the detallemovimiento database table.
 * 
 */
public class DetallemovimientoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private Integer iddetalle;

	public DetallemovimientoPK() {
	}

	public Integer getIdmovimiento() {
		return this.idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public Integer getIddetalle() {
		return this.iddetalle;
	}

	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}
}