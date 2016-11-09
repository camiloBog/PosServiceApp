package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the tipomedida database table.
 * 
 */
public class TipoMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtipomedida;
	private String descripcion;

	public TipoMedida(Integer idtipomedida, String descripcion) {
		this.idtipomedida = idtipomedida;
		this.descripcion = descripcion;
	}

	public TipoMedida() {

	}

	public Integer getIdtipomedida() {
		return this.idtipomedida;
	}

	public void setIdtipomedida(Integer idtipomedida) {
		this.idtipomedida = idtipomedida;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}