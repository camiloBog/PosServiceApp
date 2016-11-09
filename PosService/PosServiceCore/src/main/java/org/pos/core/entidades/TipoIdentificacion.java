package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the tipoidentificacion database table.
 * 
 */
public class TipoIdentificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ididentificacion;
	private String descripcion;

	public TipoIdentificacion(Integer ididentificacion, String descripcion) {
		this.ididentificacion = ididentificacion;
		this.descripcion = descripcion;
	}

	public TipoIdentificacion() {
		
	}

	public Integer getIdidentificacion() {
		return this.ididentificacion;
	}

	public void setIdidentificacion(Integer ididentificacion) {
		this.ididentificacion = ididentificacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}