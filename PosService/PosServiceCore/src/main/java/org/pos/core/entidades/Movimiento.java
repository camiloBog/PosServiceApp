package org.pos.core.entidades;

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

	private Timestamp fecha;
	private List<Detallemovimiento> detallemovimientos;
	private Persona persona1;
	private Persona persona2;
	private Tipomovimiento tipomovimiento;
	private Usuario usuario;

	public Movimiento() {
	}

	public Integer getIdmovimiento() {
		return this.idmovimiento;
	}

	public void setIdmovimiento(Integer idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public List<Detallemovimiento> getDetallemovimientos() {
		return this.detallemovimientos;
	}

	public void setDetallemovimientos(List<Detallemovimiento> detallemovimientos) {
		this.detallemovimientos = detallemovimientos;
	}

	public Persona getPersona1() {
		return this.persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return this.persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

	public Tipomovimiento getTipomovimiento() {
		return this.tipomovimiento;
	}

	public void setTipomovimiento(Tipomovimiento tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}