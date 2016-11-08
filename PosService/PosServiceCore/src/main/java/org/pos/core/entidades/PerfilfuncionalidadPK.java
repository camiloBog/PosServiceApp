package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The primary key class for the perfilfuncionalidad database table.
 * 
 */
public class PerfilfuncionalidadPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idperfil;
	private Integer idfuncionalidad;

	public PerfilfuncionalidadPK() {
	}

	public Integer getIdperfil() {
		return this.idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public Integer getIdfuncionalidad() {
		return this.idfuncionalidad;
	}

	public void setIdfuncionalidad(Integer idfuncionalidad) {
		this.idfuncionalidad = idfuncionalidad;
	}
}