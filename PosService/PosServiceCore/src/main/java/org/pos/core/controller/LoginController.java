package org.pos.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MenuDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.TipoIdentificacion;
import org.pos.db.entidades.Usuario;

public class LoginController {

	public LoginResponseDto validate(String usuario, String contrasena) {
		
		Logger log = LogManager.getLogger(LoginController.class);
		
		UsuarioDao dao = null;
		Usuario usu = null;
		
		try {
			dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			usu = dao.validate(usuario, contrasena);
		} catch (Exception e) {
			log.error("Ocurrio un error al realizar la validacion de usuario.");
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
		TipoIdentificacionDao dao2 = null;
		List<TipoIdentificacion> ti = null;
		
		try {
			dao2 = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			ti = dao2.findAll();
		} catch (Exception e) {
			log.error("Ocurrio un error al realizar la validacion de usuario.");
			log.error(e.getMessage());
		}finally {
			if(null!=dao2)
				dao2.close();
		}
		
		if (usu!=null) {
			
			MenuDto menu = new MenuDto(true);
			
			LoginResponseDto login = new LoginResponseDto();
			login.setMensaje("");
			login.setNombre(usu.getNombre());
			login.setTenant(usu.getIdtenant());
			login.setUsuario(usu.getUsuario());
			login.setValidacion(true);
			login.setMenu(menu);
			login.setTiposIdentificacion(ti);
			
			return login;
			
		} else {
			return null;
		}
		
	}
}
