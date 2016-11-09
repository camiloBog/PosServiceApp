package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the perfilfuncionalidad database table.
 * 
 */
public class PerfilFuncionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idperfil;
	private Integer idfuncionalidad;
	private Boolean borra;
	private Boolean inserta;
	private Boolean modificia;

	public PerfilFuncionalidad() {

	}

	public PerfilFuncionalidad(Integer idperfil, Integer idfuncionalidad, Boolean borra, Boolean inserta,
			Boolean modificia) {
		this.idperfil = idperfil;
		this.idfuncionalidad = idfuncionalidad;
		this.borra = borra;
		this.inserta = inserta;
		this.modificia = modificia;
	}

	public Integer getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public Integer getIdfuncionalidad() {
		return idfuncionalidad;
	}

	public void setIdfuncionalidad(Integer idfuncionalidad) {
		this.idfuncionalidad = idfuncionalidad;
	}

	public Boolean getBorra() {
		return borra;
	}

	public void setBorra(Boolean borra) {
		this.borra = borra;
	}

	public Boolean getInserta() {
		return inserta;
	}

	public void setInserta(Boolean inserta) {
		this.inserta = inserta;
	}

	public Boolean getModificia() {
		return modificia;
	}

	public void setModificia(Boolean modificia) {
		this.modificia = modificia;
	}

}