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
import org.pos.core.controller.UsuarioController;
import org.pos.core.dto.MsgResponseDto;

@Path("conf")
public class RegistroSrv {

	private Logger log = LogManager.getLogger(RegistroSrv.class);

	@GET
	@Path("reg/ten/{tipoid}/{id}/{nom}/{dir}/{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarTenant(
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
	
	@GET
	@Path("cons/ten/cod/{cod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByCod(
			@PathParam("cod") String cod) {

		log.info("Buscando Tenant por codigo: " + cod);
		MsgResponseDto response = new TenantController().BuscaTenantByCod(cod);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con el codigo: " + cod);
			return Response.status(200).entity(null).build();
		}
	}
	
	@GET
	@Path("cons/ten/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarTenantByIdentificacion(
			@PathParam("id") String id) {

		log.info("Buscando Tenant por Id: " + id);
		MsgResponseDto response = new TenantController().findByIdentificacion(id);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con el Id: " + id);
			return Response.status(200).entity(null).build();
		}
	}
		
	@GET
	@Path("reg/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarUsuario(
			@PathParam("usuario") String usuario, 
			@PathParam("nombre") String nombre,
			@PathParam("apellidos") String apellidos,
			@PathParam("contrasena") String contrasena,
			@PathParam("idperfil") String idperfil,
			@PathParam("idtenant") String idtenant) {

		log.info("Registrando Usuario " + nombre);
		MsgResponseDto response = new UsuarioController().crearUSuario(usuario, 
				nombre, apellidos, contrasena, idperfil, idtenant) ;

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del usuario: " + usuario);
			return Response.status(200).entity(null).build();
		}
	}
	
	@GET
	@Path("cons/usu/{usu}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarUsuario(
			@PathParam("usu") String usu) {

		log.info("Buscando Usuario: " + usu);
		MsgResponseDto response = new UsuarioController().BuscaUsuario(usu);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el usuario: " + usu);
			return Response.status(200).entity(null).build();
		}
		
	}
	
	@GET
	@Path("actu/usu/{usuario}/{nombre}/{apellidos}/{contrasena}/{idperfil}/{idtenant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarUsuario(
			@PathParam("usuario") String usuario, 
			@PathParam("nombre") String nombre,
			@PathParam("apellidos") String apellidos,
			@PathParam("contrasena") String contrasena,
			@PathParam("idperfil") String idperfil,
			@PathParam("idtenant") String idtenant) {

		log.info("Actualizando Usuario:" + usuario);
		MsgResponseDto response = new UsuarioController().actualizarUSuario(usuario, 
				nombre, apellidos, contrasena, idperfil, idtenant) ;

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible actualizar el usuario:" + usuario);
			return Response.status(200).entity(null).build();
		}
	}

}