package org.pos.rest.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.db.entidades.Usuarios;

@Path("loginsrv")
public interface LoginService {
	
	@POST
	@Path("validar/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validaUsuario(Usuarios usuario);

}
