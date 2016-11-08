package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the almacen database table.
 * 
 */
public class Almacen implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idalmacen;
	private Integer contacto;
	private Long descripcion;
	private Long direccion;
	private String mail;
	private String telefono;

	private Ciudad ciudad;
	private List<Almacenproducto> almacenproductos;
	private List<Detallemovimiento> detallemovimientos;

	public Almacen() {
	}

	public Integer getIdalmacen() {
		return this.idalmacen;
	}

	public void setIdalmacen(Integer idalmacen) {
		this.idalmacen = idalmacen;
	}

	public Integer getContacto() {
		return this.contacto;
	}

	public void setContacto(Integer contacto) {
		this.contacto = contacto;
	}

	public Long getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(Long descripcion) {
		this.descripcion = descripcion;
	}

	public Long getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Long direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
}