package org.pos.core.login;

import org.pos.core.dto.LoginResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.Usuario;

public class LoginController {

	public LoginResponseDto validate(String usuario, String contrasena) {

		UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class, "public");
		Usuario usu = dao.validate(usuario, contrasena);
		
		
		
		return null;
	}
}
