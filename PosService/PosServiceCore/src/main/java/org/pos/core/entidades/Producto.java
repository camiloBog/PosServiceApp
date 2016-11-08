package org.pos.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the producto database table.
 * 
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idproducto;
	private String descripcion;
	private Integer idfabricante;
	private BigDecimal medida;

	private List<Almacenproducto> almacenproductos;
	private List<Detallemovimiento> detallemovimientos;
	private Tipomedida tipomedida;

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

	public List<Almacenproducto> getAlmacenproductos() {
		return this.almacenproductos;
	}

	public void setAlmacenproductos(List<Almacenproducto> almacenproductos) {
		this.almacenproductos = almacenproductos;
	}

	public List<Detallemovimiento> getDetallemovimientos() {
		return this.detallemovimientos;
	}

	public void setDetallemovimientos(List<Detallemovimiento> detallemovimientos) {
		this.detallemovimientos = detallemovimientos;
	}

	public Tipomedida getTipomedida() {
		return this.tipomedida;
	}

	public void setTipomedida(Tipomedida tipomedida) {
		this.tipomedida = tipomedida;
	}

}