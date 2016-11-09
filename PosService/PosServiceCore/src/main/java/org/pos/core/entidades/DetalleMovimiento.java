package org.pos.core.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the detallemovimiento database table.
 * 
 */
public class DetalleMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private Integer iddetalle;
	private Integer idalmacen;
	private Integer idproducto;
	private Integer cantidad;
	private BigDecimal valorcompra;
	private BigDecimal valorventa;

	public DetalleMovimiento(Integer idmovimiento, Integer iddetalle, Integer idalmacen, Integer idproducto,
			Integer cantidad, BigDecimal valorcompra, BigDecimal valorventa) {
		this.idmovimiento = idmovimiento;
		this.iddetalle = iddetalle;
		this.idalmacen = idalmacen;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.valorcompra = valorcompra;
		this.valorventa = valorventa;
	}

	public DetalleMovimiento() {

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

	public Integer getIdalmacen() {
		return idalmacen;
	}

	public void setIdalmacen(Integer idalmacen) {
		this.idalmacen = idalmacen;
	}

	public Integer getIdmovimiento() {
		return idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}

}