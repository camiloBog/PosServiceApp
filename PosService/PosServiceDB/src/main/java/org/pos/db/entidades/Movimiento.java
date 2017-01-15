package org.pos.db.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the movimiento database table.
 * 
 */
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private Integer idtipomovimiento;
	private Integer idpersona;
	private Timestamp fecha;
	private Integer idusuario;
	private String usuario;
	
	private List<DetalleMovimiento> detallemovimiento;
	
	public Movimiento(Integer idmovimiento, Integer idtipomovimiento, Integer idpersona,
			Timestamp fecha, Integer idusuario) {
		this.idmovimiento = idmovimiento;
		this.idtipomovimiento = idtipomovimiento;
		this.idpersona = idpersona;
		this.fecha = fecha;
		this.idusuario = idusuario;
	}

	public Movimiento() {

	}

	public Integer getIdmovimiento() {
		return idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public Integer getIdtipomovimiento() {
		return idtipomovimiento;
	}

	public void setIdtipomovimiento(Integer idtipomovimiento) {
		this.idtipomovimiento = idtipomovimiento;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<DetalleMovimiento> getDetallemovimiento() {
		return detallemovimiento;
	}

	public void setDetallemovimiento(List<DetalleMovimiento> detallemovimiento) {
		this.detallemovimiento = detallemovimiento;
	}

}