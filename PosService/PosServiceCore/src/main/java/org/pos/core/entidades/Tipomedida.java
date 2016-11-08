package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tipomedida database table.
 * 
 */
public class Tipomedida implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtipomedida;
	private String descripcion;

	private List<Producto> productos;

	public Tipomedida() {
	}

	public Integer getIdtipomedida() {
		return this.idtipomedida;
	}

	public void setIdtipomedida(Integer idtipomedida) {
		this.idtipomedida = idtipomedida;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}