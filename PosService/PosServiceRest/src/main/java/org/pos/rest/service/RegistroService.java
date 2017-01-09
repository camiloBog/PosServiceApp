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

//	@Path("reg/ten/{tipoid}/{id}/{nom}/{dir}/{tel}")
	@POST
	@Path("reg/ten/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarTenant(Tenant tenant);
	
	@POST
//	@Path("cons/ten/cod/{cod}")
	@Path("cons/ten/cod/")
	@Produces(MediaType.APPLICATION_JSON)
//	public Response BuscarTenantByCod(Tenant tenant);
	public Response BuscarTenantById(Tenant tenant);
	
	@POST
//	@Path("cons/ten/id/{id}")
	@Path("cons/ten/id/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByIdentificacion(Tenant tenant);
	
//	@Path("reg/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@POST
	@Path("reg/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarUsuario(Usuarios usuario);
	
	@POST
//	@Path("cons/usu/{usu}")
	@Path("cons/usu/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarUsuario(Usuarios usuario);
	
	@POST
	@Path("actu/usu/")
//	@Path("actu/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarUsuario(Usuarios usuario);

}