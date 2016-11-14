package org.pos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.TenantController;
import org.pos.core.dto.MsgResponseDto;

@Path("conf")
public class RegistroSrv {

	private Logger log = LogManager.getLogger(RegistroSrv.class);

	@GET
	@Path("registrar/{tipoid}/{id}/{nom}/{dir}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valida(
			@PathParam("tipoid") String tipoidentificacion, 
			@PathParam("id") String identificacion,
			@PathParam("nom") String nombre, 
			@PathParam("dir") String direccion, 
			@PathParam("tel") String telefono) {

		log.info("Registrando Tenant " + nombre);
		MsgResponseDto response = new TenantController().registra(tipoidentificacion, 
				identificacion, nombre, direccion, telefono);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del tenant " + nombre);
			return Response.status(200).entity(null).build();
		}

	}

}