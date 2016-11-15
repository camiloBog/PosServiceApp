package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the usuario database table.
 * 
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private String usuario;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private Integer idperfiles;
	private Integer idtenant;

	public Usuario(Integer idusuario, String usuario, String nombre, String apellidos, String contrasena,
			Integer idperfiles, Integer idtenant) {
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.idperfiles = idperfiles;
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

	public Integer getIdPerfiles() {
		return idperfiles;
	}

	public void setIdPerfil(Integer idperfiles) {
		this.idperfiles = idperfiles;
	}

	public Integer getIdtenant() {
		return idtenant;
	}

	public void setIdtenant(Integer idtenant) {
		this.idtenant = idtenant;
	}

}