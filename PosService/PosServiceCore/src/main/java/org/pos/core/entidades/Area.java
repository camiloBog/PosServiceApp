package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the area database table.
 * 
 */
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idarea;
	private String descripcion;

	private List<Usuario> usuarios;

	public Area() {
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

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}