package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The persistent class for the perfilfuncionalidad database table.
 * 
 */
public class Perfilfuncionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private PerfilfuncionalidadPK id;
	private Boolean borra;
	private Boolean inserta;
	private Boolean modificia;

	private Funcionalidad funcionalidad;
	private Perfile perfile;

	public Perfilfuncionalidad() {
	}

	public PerfilfuncionalidadPK getId() {
		return this.id;
	}

	public void setId(PerfilfuncionalidadPK id) {
		this.id = id;
	}

	public Boolean getBorra() {
		return this.borra;
	}

	public void setBorra(Boolean borra) {
		this.borra = borra;
	}

	public Boolean getInserta() {
		return this.inserta;
	}

	public void setInserta(Boolean inserta) {
		this.inserta = inserta;
	}

	public Boolean getModificia() {
		return this.modificia;
	}

	public void setModificia(Boolean modificia) {
		this.modificia = modificia;
	}

	public Funcionalidad getFuncionalidad() {
		return this.funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

}