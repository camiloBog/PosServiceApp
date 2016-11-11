package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the ciudad database table.
 * 
 */
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idciudad;
	private String descripcion;

	public Ciudad(Integer idciudad, String descripcion) {
		this.idciudad = idciudad;
		this.descripcion = descripcion;
	}

	public Ciudad() {
		
	}

	public Integer getIdciudad() {
		return this.idciudad;
	}

	public void setIdciudad(Integer idciudad) {
		this.idciudad = idciudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}