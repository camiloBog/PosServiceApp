package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the area database table.
 * 
 */
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idarea;
	private String descripcion;

	public Area() {
		
	}

	public Area(Integer idarea, String descripcion) {
		this.idarea = idarea;
		this.descripcion = descripcion;
	}

	public Integer getIdarea() {
		return this.idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}