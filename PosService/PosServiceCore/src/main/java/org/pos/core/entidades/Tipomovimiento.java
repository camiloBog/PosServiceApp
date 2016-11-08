package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tipomovimiento database table.
 * 
 */
public class Tipomovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private String descripcion;

	private List<Movimiento> movimientos;

	public Tipomovimiento() {
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

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

}