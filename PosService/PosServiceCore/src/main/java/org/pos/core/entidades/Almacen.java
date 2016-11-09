package org.pos.core.entidades;

import java.io.Serializable;

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
	private Integer idciudad;

	public Almacen() {
		
	}

	public Almacen(Integer idalmacen, Integer contacto, Long descripcion,
			Long direccion, String mail, String telefono, Integer idciudad) {
		this.idalmacen = idalmacen;
		this.contacto = contacto;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.idciudad = idciudad;
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

	public Integer getIdciudad() {
		return idciudad;
	}

	public void setIdciudad(Integer idciudad) {
		this.idciudad = idciudad;
	}

}