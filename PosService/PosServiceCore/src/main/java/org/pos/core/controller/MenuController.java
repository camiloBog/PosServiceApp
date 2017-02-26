package org.pos.core.controller;

import org.pos.core.dto.MenuDto;

public class MenuController {

	public MenuController() {

	}
	
	public MenuDto getFullAdministrador(){
		return new MenuDto(true);
	}
	
	public MenuDto getAdministrador(){
		
		MenuDto menu = new MenuDto(true);
		menu.setHeadConsultas(false);
		menu.setHeadFacturacion(false);
		menu.setHeadInventario(false);
		menu.setIngreso(false);
		menu.setInventario(false);
		menu.setProductos(false);
		menu.setProveedores(false);
		menu.setVentas(false);
		
		return menu;
		
	}
	
	public MenuDto getUsuario(){
		
		MenuDto menu = new MenuDto(true);
		menu.setHeadConfiguracion(false);
		menu.setUsuario(false);
		menu.setTenan(false);
		menu.setHeadConsultas(false);
		
		return menu;
		
	}

}
