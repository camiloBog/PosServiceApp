package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tipopersonas database table.
 * 
 */
public class Tipopersona implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtipopersona;
	private String descripcion;

	private List<Persona> personas;

	public Tipopersona() {
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

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}