package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.TenantController;
import org.pos.core.controller.UsuarioController;
import org.pos.core.dto.MsgResponseDto;
import org.pos.rest.service.RegistroService;

public class RegistroImpl implements RegistroService {

	private Logger log = LogManager.getLogger(RegistroImpl.class);

	public Response RegistrarTenant(String tipoidentificacion, String identificacion, 
			String nombre, String direccion, String telefono) {

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
	
	public Response BuscarTenantByCod(String cod) {

		log.info("Buscando Tenant por codigo: " + cod);
		MsgResponseDto response = new TenantController().BuscaTenantByCod(cod);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con el codigo: " + cod);
			return Response.status(200).entity(null).build();
		}
	}

	public Response BuscarTenantByIdentificacion(String id) {

		log.info("Buscando Tenant por Id: " + id);
		MsgResponseDto response = new TenantController().findByIdentificacion(id);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con el Id: " + id);
			return Response.status(200).entity(null).build();
		}
	}
		
	public Response RegistrarUsuario(String usuario, String nombre, 
			String apellidos, String contrasena, String idperfil, String idtenant) {

		log.info("Registrando Usuario " + nombre);
		MsgResponseDto response = new UsuarioController().
				crearUSuario(usuario, nombre, apellidos, contrasena, idperfil, idtenant);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del usuario: " + usuario);
			return Response.status(200).entity(null).build();
		}
	}
	
	public Response BuscarUsuario(String usu) {

		log.info("Buscando Usuario: " + usu);
		MsgResponseDto response = new UsuarioController().BuscaUsuario(usu);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el usuario: " + usu);
			return Response.status(200).entity(null).build();
		}
		
	}
	
	public Response ActualizarUsuario(String usuario, String nombre, 
			String apellidos, String contrasena, String idperfil, String idtenant) {

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