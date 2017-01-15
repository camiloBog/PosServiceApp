package org.pos.db.entidades;

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
	private Integer idproducto;
	private Integer cantidad;
	private BigDecimal valor;
	private String observacion;

	public DetalleMovimiento(Integer idmovimiento, Integer iddetalle, Integer idproducto,
			Integer cantidad, BigDecimal valor, String observacion) {
		this.idmovimiento = idmovimiento;
		this.iddetalle = iddetalle;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.valor = valor;
		this.observacion = observacion;
	}

	public DetalleMovimiento() {

	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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