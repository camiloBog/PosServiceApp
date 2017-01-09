package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.UsuarioController;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.entidades.Usuarios;
import org.pos.rest.service.LoginService;

public class LoginImpl implements LoginService {
	
	private Logger log = LogManager.getLogger(LoginImpl.class);

	@Override
	public Response validaUsuario(Usuarios usuario) {
		
		log.info("Validando usuario: " + usuario);
		LoginResponseDto response = new UsuarioController().validarUsuario(usuario);

		if (response!=null) {
			log.info("Usuario " + usuario + " validado correctamente.");
			return Response.status(200).entity(response).build();
		} else {
			log.warn("Autenticacion INCORRECTA para el Usuario " + usuario);
			return Response.status(200).entity(new MsgResponseDto("Credenciales incorrectas.", false, null)).build();
		}
	}

}