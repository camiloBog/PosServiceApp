package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the funcionalidad database table.
 * 
 */
public class Funcionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idfuncionalidad;
	private String descripcion;

	private Modulo modulo;
	private List<Perfilfuncionalidad> perfilfuncionalidads;

	public Funcionalidad() {
		
	}

	public Integer getIdfuncionalidad() {
		return this.idfuncionalidad;
	}

	public void setIdfuncionalidad(Integer idfuncionalidad) {
		this.idfuncionalidad = idfuncionalidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Perfilfuncionalidad> getPerfilfuncionalidads() {
		return this.perfilfuncionalidads;
	}

	public void setPerfilfuncionalidads(List<Perfilfuncionalidad> perfilfuncionalidads) {
		this.perfilfuncionalidads = perfilfuncionalidads;
	}

}