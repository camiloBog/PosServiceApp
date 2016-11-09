package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the perfiles database table.
 * 
 */
public class Perfiles implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idperfil;
	private String descripcion;

	public Perfiles(Integer idperfil, String descripcion) {
		this.idperfil = idperfil;
		this.descripcion = descripcion;
	}

	public Perfiles() {

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

}