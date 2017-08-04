package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.TenantController;
import org.pos.core.controller.UsuarioController;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.Usuarios;
import org.pos.rest.service.RegistroService;

public class RegistroImpl implements RegistroService {

	private Logger log = LogManager.getLogger(RegistroImpl.class);

	@Override
	public Response RegistrarTenant(Tenant tenant) {

		log.info("Registrando Tenant " + tenant.getNombre());
		MsgResponseDto response = new TenantController().registra(tenant);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del tenant " + tenant.getNombre());
			return Response.status(200).entity(null).build();
		}
	}
	
	@Override
	public Response BuscarTenant(Tenant tenant) {
		
		log.info("Buscando Tenant dimanicamente...");
		MsgResponseDto response = new TenantController().BuscaTenant(tenant);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant" + tenant.getIdtenant());
			return Response.status(200).entity(null).build();
		}
	}
	
	@Override
	public Response BuscarTenantById(Tenant tenant) {

		log.info("Buscando Tenant por Idtenant: " + tenant.getIdtenant());
		MsgResponseDto response = new TenantController().BuscaTenantById(tenant.getIdtenant());

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con el codigo: " + tenant.getIdtenant());
			return Response.status(200).entity(null).build();
		}
	}

	@Override
	public Response BuscarTenantByIdentificacion(Tenant tenant) {

		log.info("Buscando Tenant por Identification: " + tenant.getIdentificacion());
		MsgResponseDto response = new TenantController().findByIdentificacion(tenant.getIdentificacion());

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el tenant con la Identification: " + tenant.getIdentificacion());
			return Response.status(200).entity(null).build();
		}
	}
	
	@Override
	public Response EliminarTenant(Tenant tenant) {

		log.info("Eliminando Tenant...");
		MsgResponseDto response = new TenantController().eliminaTenant(tenant);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible eliminar el tenant" + tenant.getIdtenant());
			return Response.status(200).entity(null).build();
		}
	}
	
	@Override
	public Response RegistrarUsuario(Usuarios usuario) {

		log.info("Registrando Usuario " + usuario.getNombre());
		
		MsgResponseDto response = new UsuarioController().crearUSuario(usuario);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del usuario: " + usuario);
			return Response.status(200).entity(null).build();
		}
	}
	
	@Override
	public Response ConsultarUsuario(Usuarios usuario) {
		
		log.info("Consultando Usuario dinamicamente...");
		
		MsgResponseDto response = new UsuarioController().BuscarUsuario(usuario);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible consultar el registro del usuario.");
			return Response.status(200).entity(null).build();
		}
		
	}
	
	@Override
	public Response BuscarUsuario(Usuarios usuario) {

		log.info("Buscando Usuario: " + usuario.getUsuario());
		MsgResponseDto response = new UsuarioController().buscaUsuarioSeguridad(usuario);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible encontrar el usuario: " + usuario.getUsuario());
			return Response.status(200).entity(null).build();
		}
		
	}
	
	@Override
	public Response ActualizarUsuario(Usuarios usuario) {

		log.info("Actualizando Usuario:" + usuario.getUsuario());
		MsgResponseDto response = new UsuarioController().actualizarUSuario(usuario) ;

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible actualizar el usuario:" + usuario.getUsuario());
			return Response.status(200).entity(null).build();
		}
	}

	@Override
	public Response EliminarUsuario(Usuarios usuario) {
		
		log.info("Eliminando Usuario");		
		MsgResponseDto response = new UsuarioController().eliminar(usuario);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible eliminar el usuario");
			return Response.status(200).entity(null).build();
		}
		
	}

}