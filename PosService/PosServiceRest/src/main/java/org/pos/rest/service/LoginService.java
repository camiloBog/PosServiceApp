package org.pos.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("loginsrv")
public interface LoginService {
	
	@GET
	@Path("validar/{usu}/{pas}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valida(
			@PathParam("usu") String usuario, 
			@PathParam("pas") String pass);

}
