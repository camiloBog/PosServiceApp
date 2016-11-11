package org.pos.core.dto;

public class MenuDto {

	private boolean headConfiguracion;
	private boolean tenan;
	private boolean usuario;
	private boolean headInventario;
	private boolean proveedores;
	private boolean productos;
	private boolean ingreso;
	private boolean headFacturacion;
	private boolean headConsultas;
	private boolean inventario;
	private boolean ventas;
	
	public MenuDto(boolean headConfiguracion, boolean tenan, boolean usuario, boolean headInventario,
			boolean proveedores, boolean productos, boolean ingreso, boolean headFacturacion, boolean headConsultas,
			boolean inventario, boolean ventas) {
		this.headConfiguracion = headConfiguracion;
		this.tenan = tenan;
		this.usuario = usuario;
		this.headInventario = headInventario;
		this.proveedores = proveedores;
		this.productos = productos;
		this.ingreso = ingreso;
		this.headFacturacion = headFacturacion;
		this.headConsultas = headConsultas;
		this.inventario = inventario;
		this.ventas = ventas;
	}
	
	public MenuDto(boolean permisos) {
		this.headConfiguracion = permisos;
		this.tenan = permisos;
		this.usuario = permisos;
		this.headInventario = permisos;
		this.proveedores = permisos;
		this.productos = permisos;
		this.ingreso = permisos;
		this.headFacturacion = permisos;
		this.headConsultas = permisos;
		this.inventario = permisos;
		this.ventas = permisos;
	}

	public MenuDto() {
		
	}

	public boolean isHeadConfiguracion() {
		return headConfiguracion;
	}

	public void setHeadConfiguracion(boolean headConfiguracion) {
		this.headConfiguracion = headConfiguracion;
	}

	public boolean isTenan() {
		return tenan;
	}

	public void setTenan(boolean tenan) {
		this.tenan = tenan;
	}

	public boolean isUsuario() {
		return usuario;
	}

	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}

	public boolean isHeadInventario() {
		return headInventario;
	}

	public void setHeadInventario(boolean headInventario) {
		this.headInventario = headInventario;
	}

	public boolean isProveedores() {
		return proveedores;
	}

	public void setProveedores(boolean proveedores) {
		this.proveedores = proveedores;
	}

	public boolean isProductos() {
		return productos;
	}

	public void setProductos(boolean productos) {
		this.productos = productos;
	}

	public boolean isIngreso() {
		return ingreso;
	}

	public void setIngreso(boolean ingreso) {
		this.ingreso = ingreso;
	}

	public boolean isHeadFacturacion() {
		return headFacturacion;
	}

	public void setHeadFacturacion(boolean headFacturacion) {
		this.headFacturacion = headFacturacion;
	}

	public boolean isHeadConsultas() {
		return headConsultas;
	}

	public void setHeadConsultas(boolean headConsultas) {
		this.headConsultas = headConsultas;
	}

	public boolean isInventario() {
		return inventario;
	}

	public void setInventario(boolean inventario) {
		this.inventario = inventario;
	}

	public boolean isVentas() {
		return ventas;
	}

	public void setVentas(boolean ventas) {
		this.ventas = ventas;
	}
	
}
