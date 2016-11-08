package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the persona database table.
 * 
 */
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idpersona;
	private Long contacto;
	private Long correocontacto;
	private Long direccion;
	private Long identificacion;
	private Long nombre;
	private Long telefono;

	private List<Movimiento> movimientos1;
	private List<Movimiento> movimientos2;
	private Tipoidentificacion tipoidentificacion;
	private Tipopersona tipopersona;

	public Persona() {
	}

	public Integer getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Long getContacto() {
		return this.contacto;
	}

	public void setContacto(Long contacto) {
		this.contacto = contacto;
	}

	public Long getCorreocontacto() {
		return this.correocontacto;
	}

	public void setCorreocontacto(Long correocontacto) {
		this.correocontacto = correocontacto;
	}

	public Long getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Long direccion) {
		this.direccion = direccion;
	}

	public Long getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public Long getNombre() {
		return this.nombre;
	}

	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public List<Movimiento> getMovimientos1() {
		return this.movimientos1;
	}

	public void setMovimientos1(List<Movimiento> movimientos1) {
		this.movimientos1 = movimientos1;
	}

	public List<Movimiento> getMovimientos2() {
		return this.movimientos2;
	}

	public void setMovimientos2(List<Movimiento> movimientos2) {
		this.movimientos2 = movimientos2;
	}

	public Tipoidentificacion getTipoidentificacion() {
		return this.tipoidentificacion;
	}

	public void setTipoidentificacion(Tipoidentificacion tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}

	public Tipopersona getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(Tipopersona tipopersona) {
		this.tipopersona = tipopersona;
	}

}