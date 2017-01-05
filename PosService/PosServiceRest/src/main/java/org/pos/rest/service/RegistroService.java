package org.pos.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("conf")
public interface RegistroService {

	@GET
	@Path("reg/ten/{tipoid}/{id}/{nom}/{dir}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarTenant(
			@PathParam("tipoid") String tipoidentificacion, 
			@PathParam("id") String identificacion,
			@PathParam("nom") String nombre, 
			@PathParam("dir") String direccion, 
			@PathParam("tel") String telefono);
	
	@GET
	@Path("cons/ten/cod/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByCod(
			@PathParam("cod") String cod);
	
	@GET
	@Path("cons/ten/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByIdentificacion(
			@PathParam("id") String id);
		
	@GET
	@Path("reg/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarUsuario(
			@PathParam("usuario") String usuario, 
			@PathParam("nombre") String nombre,
			@PathParam("apellidos") String apellidos,
			@PathParam("contrasena") String contrasena,
			@PathParam("idperfil") String idperfil,
			@PathParam("idtenant") String idtenant);
	
	@GET
	@Path("cons/usu/{usu}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarUsuario(
			@PathParam("usu") String usu);
	
	@GET
	@Path("actu/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarUsuario(
			@PathParam("usuario") String usuario, 
			@PathParam("nombre") String nombre,
			@PathParam("apellidos") String apellidos,
			@PathParam("contrasena") String contrasena,
			@PathParam("idperfil") String idperfil,
			@PathParam("idtenant") String idtenant);

}