package org.pos.rest.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.Usuarios;

@Path("conf")
public interface RegistroService {

	@POST
	@Path("reg/ten/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarTenant(Tenant tenant);
	
	@POST
	@Path("cons/ten/cod/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantById(Tenant tenant);
	
	@POST
	@Path("cons/ten/id/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByIdentificacion(Tenant tenant);
	
	@POST
	@Path("reg/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarUsuario(Usuarios usuario);
	
	@POST
	@Path("cons/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ConsultarUsuario(Usuarios usuario);
	
	@POST
	@Path("cons/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarUsuario(Usuarios usuario);
	
	@POST
	@Path("actu/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarUsuario(Usuarios usuario);

}