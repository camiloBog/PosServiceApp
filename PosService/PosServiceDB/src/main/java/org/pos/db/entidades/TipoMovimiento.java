package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the tipomovimiento database table.
 * 
 */
public class TipoMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private String descripcion;

	public TipoMovimiento(Integer idmovimiento, String descripcion) {
		this.idmovimiento = idmovimiento;
		this.descripcion = descripcion;
	}

	public TipoMovimiento() {
		
	}

	public Integer getIdmovimiento() {
		return this.idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}