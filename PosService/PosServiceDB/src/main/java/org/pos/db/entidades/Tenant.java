package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the tenant database table.
 * 
 */
public class Tenant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtenant;
	private Integer tipoidentificacion;
	private String identificacion;
	private String nombre;
	private String direccion;
	private String telefono;
	private String esquema;

	public Tenant(Integer idtenant, Integer tipoidentificacion, 
			String identificacion, String nombre, String direccion,
			String telefono, String esquema) {
		this.idtenant = idtenant;
		this.tipoidentificacion = tipoidentificacion;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.esquema = esquema;
	}

	public Tenant() {

	}

	public Integer getIdtenant() {
		return this.idtenant;
	}

	public void setIdtenant(Integer idtenant) {
		this.idtenant = idtenant;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEsquema() {
		return this.esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipoidentificacion() {
		return this.tipoidentificacion;
	}

	public void setTipoidentificacion(Integer tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
}