package org.pos.core.entidades;

import java.io.Serializable;

/**
 * The primary key class for the almacenproducto database table.
 * 
 */
public class AlmacenproductoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idalmacen;
	private Integer idproducto;

	public AlmacenproductoPK() {
	}

	public Integer getIdalmacen() {
		return this.idalmacen;
	}

	public void setIdalmacen(Integer idalmacen) {
		this.idalmacen = idalmacen;
	}

	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

}