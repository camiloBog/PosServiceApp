package org.pos.core.dto;

import java.util.List;

import org.pos.db.entidades.TipoIdentificacion;

public class LoginResponseDto {

	private boolean validacion;
	private Integer tenant;
	private String usuario;
	private String nombre;
	private String mensaje;
	private MenuDto menu;
	private List<TipoIdentificacion> tiposIdentificacion;
	
	public LoginResponseDto() {

	}

	public LoginResponseDto(boolean validacion, Integer tenant, String usuario, String nombre, String mensaje,
			MenuDto menu, List<TipoIdentificacion> tiposIdentificacion) {
		super();
		this.validacion = validacion;
		this.tenant = tenant;
		this.usuario = usuario;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.menu = menu;
		this.tiposIdentificacion = tiposIdentificacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isValidacion() {
		return validacion;
	}

	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
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

	public Integer getTenant() {
		return tenant;
	}

	public void setTenant(Integer tenant) {
		this.tenant = tenant;
	}

	public MenuDto getMenu() {
		return menu;
	}

	public void setMenu(MenuDto menu) {
		this.menu = menu;
	}

	public List<TipoIdentificacion> getTiposIdentificacion() {
		return tiposIdentificacion;
	}

	public void setTiposIdentificacion(List<TipoIdentificacion> tiposIdentificacion) {
		this.tiposIdentificacion = tiposIdentificacion;
	}

}
