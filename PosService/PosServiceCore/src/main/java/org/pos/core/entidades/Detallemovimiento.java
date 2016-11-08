package org.pos.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the detallemovimiento database table.
 * 
 */
public class Detallemovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cantidad;
	private BigDecimal valorcompra;
	private BigDecimal valorventa;

	private DetallemovimientoPK id;
	private Almacen almacen;
	private Movimiento movimiento;
	private Producto producto;

	public Detallemovimiento() {
	}

	public DetallemovimientoPK getId() {
		return this.id;
	}

	public void setId(DetallemovimientoPK id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorcompra() {
		return this.valorcompra;
	}

	public void setValorcompra(BigDecimal valorcompra) {
		this.valorcompra = valorcompra;
	}

	public BigDecimal getValorventa() {
		return this.valorventa;
	}

	public void setValorventa(BigDecimal valorventa) {
		this.valorventa = valorventa;
	}

	public Almacen getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Movimiento getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}