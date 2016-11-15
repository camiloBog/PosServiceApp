package org.pos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.UsuarioController;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MsgResponseDto;

@Path("loginsrv")
public class LoginSrv {

	private Logger log = LogManager.getLogger(LoginSrv.class);

	@GET
	@Path("validar/{usu}/{pas}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valida(
			@PathParam("usu") String usuario, 
			@PathParam("pas") String pass) {

		log.info("Validando usuario: " + usuario);
		LoginResponseDto response = new UsuarioController().validarUsuario(usuario, pass);

		if (response!=null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("Autenticacion INCORRECTA para el Usuario " + usuario);
			return Response.status(200).entity(new MsgResponseDto("Credenciales incorrectas.", false, null)).build();
		}
		
	}

}