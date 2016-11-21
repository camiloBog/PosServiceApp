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
	public Response buscaProducto(Producto producto) {
		
		log.info("Buscando Producto");		
		MsgResponseDto response = new ProductoController().buscar(producto);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar buscar el producto");
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
	
}