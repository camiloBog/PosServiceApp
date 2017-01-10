package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.ProductoController;
import org.pos.core.dto.MsgResponseDto;
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

}