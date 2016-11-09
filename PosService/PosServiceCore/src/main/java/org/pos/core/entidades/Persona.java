package org.pos.core.entidades;

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
	private Long nombre;
	private Long direccion;
	private Long telefono;
	private Long correocontacto;
	private Long contacto;

	public Persona(Integer idpersona, Integer idtipopersona, Integer idtipoidentificacion, Long identificacion,
			Long nombre, Long direccion, Long telefono, Long correocontacto, Long contacto) {
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

	public Long getNombre() {
		return nombre;
	}

	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}

	public Long getDireccion() {
		return direccion;
	}

	public void setDireccion(Long direccion) {
		this.direccion = direccion;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Long getCorreocontacto() {
		return correocontacto;
	}

	public void setCorreocontacto(Long correocontacto) {
		this.correocontacto = correocontacto;
	}

	public Long getContacto() {
		return contacto;
	}

	public void setContacto(Long contacto) {
		this.contacto = contacto;
	}
	
}