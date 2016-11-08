package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tipoidentificacion database table.
 * 
 */
public class Tipoidentificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ididentificacion;
	private String descripcion;

	private List<Persona> personas;

	public Tipoidentificacion() {
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

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}