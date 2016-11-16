package org.pos.db.entidades;

import java.io.Serializable;

/**
 * The persistent class for the usuario database table.
 * 
 */
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private String usuario;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private Integer idperfil;
	private Integer idtenant;

	public Usuarios(Integer idusuario, String usuario, String nombre, String apellidos, String contrasena,
			Integer idperfil, Integer idtenant) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.idperfil = idperfil;
		this.idtenant = idtenant;
	}
	
	public Usuarios() {
		
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Integer getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public Integer getIdtenant() {
		return idtenant;
	}

	public void setIdtenant(Integer idtenant) {
		this.idtenant = idtenant;
	}
	
}