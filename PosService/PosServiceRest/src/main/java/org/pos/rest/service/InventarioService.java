package org.pos.rest.service;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.db.entidades.Producto;

@Path("inv")
public interface InventarioService {
	
	@POST
	@Path("reg/prod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registraProducto(Producto producto);
	
	@POST
	@Path("busc/prod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorDescripcion(Producto producto);
	
	@PUT
	@Path("act/prod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizaProducto(Producto producto);

}
