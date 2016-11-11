package org.pos.db.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the almacenproducto database table.
 * 
 */
public class AlmacenProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idalmacen;
	private Integer idproducto;
	private BigDecimal cantidad;
	private BigDecimal stockmaximo;
	private BigDecimal stockminimo;
	private BigDecimal valorcompra;

	public AlmacenProducto() {
		
	}

	public AlmacenProducto(Integer idalmacen, Integer idproducto, BigDecimal cantidad, BigDecimal stockmaximo,
			BigDecimal stockminimo, BigDecimal valorcompra) {
		this.idalmacen = idalmacen;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.stockmaximo = stockmaximo;
		this.stockminimo = stockminimo;
		this.valorcompra = valorcompra;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getStockmaximo() {
		return stockmaximo;
	}

	public void setStockmaximo(BigDecimal stockmaximo) {
		this.stockmaximo = stockmaximo;
	}

	public BigDecimal getStockminimo() {
		return stockminimo;
	}

	public void setStockminimo(BigDecimal stockminimo) {
		this.stockminimo = stockminimo;
	}

	public BigDecimal getValorcompra() {
		return valorcompra;
	}

	public void setValorcompra(BigDecimal valorcompra) {
		this.valorcompra = valorcompra;
	}

	public Integer getIdalmacen() {
		return idalmacen;
	}

	public void setIdalmacen(Integer idalmacen) {
		this.idalmacen = idalmacen;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	
}