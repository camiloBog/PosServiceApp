package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.PersonaController;
import org.pos.core.controller.ProductoController;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.entidades.Persona;
import org.pos.db.entidades.Producto;
import org.pos.rest.service.InventarioService;

public class InventarioImpl implements InventarioService{

	private Logger log = LogManager.getLogger(InventarioImpl.class);

	@Override
	public Response registraProducto(Producto producto){
		
		log.info("Registrando Producto " + producto.getNombreproducto());		
		MsgResponseDto response = new ProductoController().registra(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro del producto " + producto.getNombreproducto());
			return Response.status(200).entity(null).build();
		}
	
	}
	
	@Override
	public Response buscarProducto(Producto producto) {
		
		log.info("Buscando Producto");		
		MsgResponseDto response = new ProductoController().buscarProducto(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible buscar el producto");
			return Response.status(200).entity(null).build();
		}
	}

	@Override
	public Response buscarPorDescripcion(Producto producto) {
		
		log.info("Buscando Producto");		
		MsgResponseDto response = new ProductoController().buscarPorDescri(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible buscar el producto");
			return Response.status(200).entity(null).build();
		}
	}

	@Override
	public Response actualizaProducto(Producto producto) {
		
		log.info("Actualizando Producto");		
		MsgResponseDto response = new ProductoController().registra(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible actualizar el producto");
			return Response.status(200).entity(null).build();
		}
	}

	@Override
	public Response borrarProducto(Producto producto) {
		
		log.info("Eliminando Producto");		
		MsgResponseDto response = new ProductoController().eliminar(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible eliminar el producto");
			return Response.status(200).entity(null).build();
		}
		
	}

	@Override
	public Response registraProveedor(Persona persona) {
		
		log.info("Registrando Persona " + persona.getNombre());		
		MsgResponseDto response = new PersonaController().registra(persona);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el registro la Persona " + persona.getNombre());
			return Response.status(200).entity(null).build();
		}
		
	}

	@Override
	public Response buscarProveedor(Persona persona) {
		
		log.info("Buscando Persona dinamicamente.");		
		MsgResponseDto response = new PersonaController().buscar(persona);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible buscar la Persona " + persona.getNombre());
			return Response.status(200).entity(null).build();
		}
		
	}

	@Override
	public Response borrarProveedor(Persona persona) {
		
		log.info("Eliminando Persona " + persona.getNombre());		
		MsgResponseDto response = new PersonaController().eliminar(persona);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible eliminar la Persona " + persona.getNombre());
			return Response.status(200).entity(null).build();
		}
		
	}

}