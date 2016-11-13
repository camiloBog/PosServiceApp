package org.pos.core.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MenuDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.UsuarioDao;
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
			e.printStackTrace();
			return null;
		}finally {
			dao.close();
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
			
			return login;
			
		} else {
			return null;
		}
		
	}
}
