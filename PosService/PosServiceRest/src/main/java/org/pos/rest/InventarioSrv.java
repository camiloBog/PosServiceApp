package org.pos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.ProductoController;
import org.pos.core.dto.MsgResponseDto;

@Path("inv")
public class InventarioSrv {

	private Logger log = LogManager.getLogger(InventarioSrv.class);

	@GET
	@Path("reg/prod/{usu}/{nom}/{des}/{med}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarProducto(
			@PathParam("nom") String nombre, 
			@PathParam("des") String descri,
			@PathParam("med") String medida,
			@PathParam("usu") String usuario
			) {

		log.info("Registrando Tenant " + nombre);
		MsgResponseDto response = new ProductoController().registra(nombre, descri, medida, usuario);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del producto " + nombre);
			return Response.status(200).entity(null).build();
		}
	}

}