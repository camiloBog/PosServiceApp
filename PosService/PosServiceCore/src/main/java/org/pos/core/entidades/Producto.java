package org.pos.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the producto database table.
 * 
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idproducto;
	private String descripcion;
	private Integer idfabricante;
	private Integer idtipomedida;
	private BigDecimal medida;

	public Producto(Integer idproducto, String descripcion, Integer idfabricante, Integer idtipomedida,
			BigDecimal medida) {
		this.idproducto = idproducto;
		this.descripcion = descripcion;
		this.idfabricante = idfabricante;
		this.idtipomedida = idtipomedida;
		this.medida = medida;
	}

	public Producto() {
		
	}

	public Integer getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdfabricante() {
		return this.idfabricante;
	}

	public void setIdfabricante(Integer idfabricante) {
		this.idfabricante = idfabricante;
	}

	public BigDecimal getMedida() {
		return this.medida;
	}

	public void setMedida(BigDecimal medida) {
		this.medida = medida;
	}

	public Integer getIdtipomedida() {
		return idtipomedida;
	}

	public void setIdtipomedida(Integer idtipomedida) {
		this.idtipomedida = idtipomedida;
	}
	
}