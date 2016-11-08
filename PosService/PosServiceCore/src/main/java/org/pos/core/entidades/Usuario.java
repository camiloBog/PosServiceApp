package org.pos.core.entidades;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private String apellidos;
	private String contrasena;
	private String nombre;
	private String usuario;
	
	private Integer idarea;
	private Integer idtenant;

	private List<Movimiento> movimientos;
	private Area area;
	private Tenant tenant;

	public Usuario(Integer idusuario, String apellidos, 
			String contrasena, String nombre, 
			String usuario, Integer idarea, Integer idtenant) {
		this.idusuario = idusuario;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.usuario = usuario;
		this.idarea = idarea;
		this.idtenant = idtenant;
	}

	public Usuario() {

	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdtenant() {
		return idtenant;
	}

	public void setIdtenant(Integer idtenant) {
		this.idtenant = idtenant;
	}

}