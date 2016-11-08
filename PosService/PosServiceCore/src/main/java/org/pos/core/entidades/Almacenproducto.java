package org.pos.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the almacenproducto database table.
 * 
 */
public class Almacenproducto implements Serializable {

	private static final long serialVersionUID = 1L;

	private AlmacenproductoPK id;
	private BigDecimal cantidad;
	private BigDecimal stockmaximo;
	private BigDecimal stockminimo;
	private BigDecimal valorcompra;

	private Almacen almacen;
	private Producto producto;

	public Almacenproducto() {
	}

	public AlmacenproductoPK getId() {
		return this.id;
	}

	public void setId(AlmacenproductoPK id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getStockmaximo() {
		return this.stockmaximo;
	}

	public void setStockmaximo(BigDecimal stockmaximo) {
		this.stockmaximo = stockmaximo;
	}

	public BigDecimal getStockminimo() {
		return this.stockminimo;
	}

	public void setStockminimo(BigDecimal stockminimo) {
		this.stockminimo = stockminimo;
	}

	public BigDecimal getValorcompra() {
		return this.valorcompra;
	}

	public void setValorcompra(BigDecimal valorcompra) {
		this.valorcompra = valorcompra;
	}

	public Almacen getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}