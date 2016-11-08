package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tenant database table.
 * 
 */
public class Tenant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idtenant;
	private String direccion;
	private String esquema;
	private String identificacion;
	private String nombre;
	private String telefono;
	private Integer tipoidentificacion;

	private List<Usuario> usuarios;

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

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}