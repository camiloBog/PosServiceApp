package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the modulo database table.
 * 
 */
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmodulo;
	private String descripcion;

	public Modulo(Integer idmodulo, String descripcion) {
		this.idmodulo = idmodulo;
		this.descripcion = descripcion;
	}

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

}