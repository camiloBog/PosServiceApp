package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the tipopersonas database table.
 * 
 */
public class TipoPersonas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtipopersona;
	private String descripcion;

	public TipoPersonas(Integer idtipopersona, String descripcion) {
		this.idtipopersona = idtipopersona;
		this.descripcion = descripcion;
	}

	public TipoPersonas() {

	}

	public Integer getIdtipopersona() {
		return this.idtipopersona;
	}

	public void setIdtipopersona(Integer idtipopersona) {
		this.idtipopersona = idtipopersona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}