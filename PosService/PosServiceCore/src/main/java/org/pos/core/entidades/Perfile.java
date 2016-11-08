package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the perfiles database table.
 * 
 */
public class Perfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idperfil;
	private String descripcion;

	private List<Perfilfuncionalidad> perfilfuncionalidads;

	public Perfile() {
	}

	public Integer getIdperfil() {
		return this.idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Perfilfuncionalidad> getPerfilfuncionalidads() {
		return this.perfilfuncionalidads;
	}

	public void setPerfilfuncionalidads(List<Perfilfuncionalidad> perfilfuncionalidads) {
		this.perfilfuncionalidads = perfilfuncionalidads;
	}

}