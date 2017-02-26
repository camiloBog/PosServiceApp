package org.pos.rest.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.core.dto.FacturacionDto;

@Path("fact")
public interface FacturacionService {

	@POST
	@Path("reg/vent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaVenta(FacturacionDto fact);
	
	@POST
	@Path("cons/vent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registraVenta(FacturacionDto fact);

}
