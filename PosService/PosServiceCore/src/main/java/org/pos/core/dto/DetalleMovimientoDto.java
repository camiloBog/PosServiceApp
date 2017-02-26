package org.pos.core.dto;

import java.math.BigDecimal;

public class DetalleMovimientoDto {
	
	private Integer idproducto;
	private String nombreproducto;
	private Integer cantidad;
	private BigDecimal valor;
	private BigDecimal valorunitario;
	
	public DetalleMovimientoDto() {
		
	}
	
	public DetalleMovimientoDto(Integer idproducto, String nombreproducto, 
			Integer cantidad, BigDecimal valor, BigDecimal valorunitario) {
		
		this.idproducto = idproducto;
		this.nombreproducto = nombreproducto;
		this.cantidad = cantidad;
		this.valor = valor;
		this.valorunitario = valorunitario;
	}
	
	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public Integer getCantidad() {
		return cantidad;
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

	public BigDecimal getValorunitario() {
		return valorunitario;
	}

	public void setValorUnitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}
	
}
