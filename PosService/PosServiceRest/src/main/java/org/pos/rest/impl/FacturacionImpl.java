package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.controller.MovimientoController;
import org.pos.core.dto.FacturacionDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.rest.service.FacturacionService;

public class FacturacionImpl implements FacturacionService{

	private Logger log = LogManager.getLogger(FacturacionImpl.class);

	@Override
	public Response registraVenta(FacturacionDto fact) {

		log.info("Registrando factura...");
		
		MsgResponseDto response = new MovimientoController().registraFactura(fact);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el Ingreso de los Productos");
			return Response.status(200).entity(null).build();
		}
		
	}

	@Override
	public Response consultaVenta(FacturacionDto fact) {
				
		log.info("Consultando facturacion...");
		
		MsgResponseDto response = new MovimientoController().consultaFactura(fact);

		if (response != null) {
			return Response.status(200).entity(response).build();
		} else {
			log.warn("No fue posible realizar el Ingreso de los Productos");
			return Response.status(200).entity(null).build();
		}
	}

	
}