package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the producto database table.
 * 
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idproducto;
	private String nombreproducto;
	private String descripcion;
	private Integer idtipomedida;
	private String tipomedida;
	private String usuario;
	private Integer precioVenta;
	private Integer existencias;
	
	public Producto() {
		
	}

	public Producto(Integer idproducto, String nombreproducto, 
			String descripcion, Integer idtipomedida,
			Integer precioVenta, Integer existencias) {
		this.idproducto = idproducto;
		this.nombreproducto = nombreproducto;
		this.descripcion = descripcion;
		this.idtipomedida = idtipomedida;
		this.precioVenta = precioVenta;
		this.setExistencias(existencias);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdtipomedida() {
		return idtipomedida;
	}

	public void setIdtipomedida(Integer idtipomedida) {
		this.idtipomedida = idtipomedida;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipomedida() {
		return tipomedida;
	}

	public void setTipomedida(String tipomedida) {
		this.tipomedida = tipomedida;
	}

	public Integer getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Integer precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
		
}