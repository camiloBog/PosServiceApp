package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the persona database table.
 * 
 */
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idpersona;
	private Integer idtipopersona;
	private Integer idtipoidentificacion;
	private Long identificacion;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correocontacto;
	private String contacto;
	private String usuario;

	public Persona(Integer idpersona, Integer idtipopersona, Integer idtipoidentificacion, Long identificacion,
			String nombre, String direccion, String telefono, String correocontacto, String contacto) {
		this.idpersona = idpersona;
		this.idtipopersona = idtipopersona;
		this.idtipoidentificacion = idtipoidentificacion;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correocontacto = correocontacto;
		this.contacto = contacto;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdtipopersona() {
		return idtipopersona;
	}

	public void setIdtipopersona(Integer idtipopersona) {
		this.idtipopersona = idtipopersona;
	}

	public Integer getIdtipoidentificacion() {
		return idtipoidentificacion;
	}

	public void setIdtipoidentificacion(Integer idtipoidentificacion) {
		this.idtipoidentificacion = idtipoidentificacion;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreocontacto() {
		return correocontacto;
	}

	public void setCorreocontacto(String correocontacto) {
		this.correocontacto = correocontacto;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}