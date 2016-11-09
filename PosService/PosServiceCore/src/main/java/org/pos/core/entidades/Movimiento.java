package org.pos.core.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the movimiento database table.
 * 
 */
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idmovimiento;
	private Integer idtipomovimiento;
	private Integer idcliente;
	private Integer idproveedor;
	private Timestamp fecha;
	private Integer idusuario;
	
	public Movimiento(Integer idmovimiento, Integer idtipomovimiento, Integer idcliente, Integer idproveedor,
			Timestamp fecha, Integer idusuario) {
		this.idmovimiento = idmovimiento;
		this.idtipomovimiento = idtipomovimiento;
		this.idcliente = idcliente;
		this.idproveedor = idproveedor;
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

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
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

}