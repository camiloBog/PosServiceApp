package org.pos.core.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FacturacionDto {
	
	private Integer idFactura;
	private String usuario;
	private String nombre;
	private Long identificacion;
	private Integer idtipoidentificacion;
	private String fecha;
	private BigDecimal valorTotal;
	private List<DetalleMovimientoDto> detallemovimiento;

	public FacturacionDto() {
		
	}
	
	public FacturacionDto(Integer idFactura, String usuario, String nombre, Long identificacion, 
			Integer idtipoidentificacion, String fecha, BigDecimal valorTotal ,
			List<DetalleMovimientoDto> detallemovimiento) {
		this.idFactura=idFactura;
		this.usuario = usuario;
		this.nombre = nombre; 
		this.identificacion = identificacion; 
		this.idtipoidentificacion = idtipoidentificacion;
		this.fecha = fecha;
		this.setValorTotal(valorTotal);
		this.detallemovimiento = detallemovimiento;
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getIdtipoidentificacion() {
		return idtipoidentificacion;
	}

	public void setIdtipoidentificacion(Integer idtipoidentificacion) {
		this.idtipoidentificacion = idtipoidentificacion;
	}

	public List<DetalleMovimientoDto> getDetallemovimiento() {
		return detallemovimiento;
	}

	public void setDetallemovimiento(List<DetalleMovimientoDto> detallemovimiento) {
		this.detallemovimiento = detallemovimiento;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
