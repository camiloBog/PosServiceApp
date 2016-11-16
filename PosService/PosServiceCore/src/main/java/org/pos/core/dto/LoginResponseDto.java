package org.pos.core.dto;

import java.util.List;

import org.pos.db.entidades.Perfiles;
import org.pos.db.entidades.TipoIdentificacion;
import org.pos.db.entidades.TipoMedida;

public class LoginResponseDto {

	private boolean validacion;
	private Integer tenant;
	private String tenantName;
	private String usuario;
	private String nombre;
	private String mensaje;
	private MenuDto menu;
	private List<TipoIdentificacion> tiposIdentificacion;
	private List<TipoMedida> tipoMedida;
	private List<Perfiles> tiposPerfiles;
	
	public LoginResponseDto() {
		
	}

	public LoginResponseDto(boolean validacion, Integer tenant, String tenantName, String usuario, String nombre,
			String mensaje, MenuDto menu, List<TipoIdentificacion> tiposIdentificacion, List<TipoMedida> tipoMedida,
			List<Perfiles> tiposPerfiles) {
		this.validacion = validacion;
		this.tenant = tenant;
		this.tenantName = tenantName;
		this.usuario = usuario;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.menu = menu;
		this.tiposIdentificacion = tiposIdentificacion;
		this.tipoMedida = tipoMedida;
		this.tiposPerfiles = tiposPerfiles;
	}

	public boolean isValidacion() {
		return validacion;
	}

	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

	public Integer getTenant() {
		return tenant;
	}

	public void setTenant(Integer tenant) {
		this.tenant = tenant;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public List<TipoMedida> getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(List<TipoMedida> tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public List<Perfiles> getTiposPerfiles() {
		return tiposPerfiles;
	}

	public void setTiposPerfiles(List<Perfiles> tiposPerfiles) {
		this.tiposPerfiles = tiposPerfiles;
	}
	
}
