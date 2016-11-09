package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the funcionalidad database table.
 * 
 */
public class Funcionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idfuncionalidad;
	private String descripcion;
	private Integer idmodulo;

	public Funcionalidad(Integer idfuncionalidad, String descripcion,
			Integer idmodulo) {
		this.idfuncionalidad = idfuncionalidad;
		this.descripcion = descripcion;
		this.idmodulo = idmodulo;
	}

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

	public Integer getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}