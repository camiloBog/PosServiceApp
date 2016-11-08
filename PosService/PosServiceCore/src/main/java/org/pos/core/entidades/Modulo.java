package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the modulo database table.
 * 
 */
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmodulo;
	private String descripcion;

	private List<Funcionalidad> funcionalidads;

	public Modulo() {
	}

	public Integer getIdmodulo() {
		return this.idmodulo;
	}

	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Funcionalidad> getFuncionalidads() {
		return this.funcionalidads;
	}

	public void setFuncionalidads(List<Funcionalidad> funcionalidads) {
		this.funcionalidads = funcionalidads;
	}
}