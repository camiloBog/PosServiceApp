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
		
//		MenuDto menu = new MenuDto(false);
//		menu.setHeadConfiguracion(true);
//		menu.setUsuario(true);
//		menu.setTenan(true);
		
		return menu;
		
	}
	
	public MenuDto getUsuario(){
		
		MenuDto menu = new MenuDto(true);
		menu.setHeadConfiguracion(false);
		menu.setUsuario(false);
		menu.setTenan(false);
		
		return menu;
		
	}

}
