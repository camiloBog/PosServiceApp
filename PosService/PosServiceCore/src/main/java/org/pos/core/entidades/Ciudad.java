package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the ciudad database table.
 * 
 */
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idciudad;
	private String descripcion;

	private List<Almacen> almacens;

	public Ciudad() {
	}

	public Integer getIdciudad() {
		return this.idciudad;
	}

	public void setIdciudad(Integer idciudad) {
		this.idciudad = idciudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Almacen> getAlmacens() {
		return this.almacens;
	}

	public void setAlmacens(List<Almacen> almacens) {
		this.almacens = almacens;
	}

}