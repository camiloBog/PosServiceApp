package org.pos.rest.impl;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.FacturacionDto;
import org.pos.rest.service.FacturacionService;

public class FacturacionImpl implements FacturacionService{

	private Logger log = LogManager.getLogger(FacturacionImpl.class);

	@Override
	public Response consultaVenta(FacturacionDto fact) {
		// TODO Auto-generated method stub
		log.info("");
		return null;
	}

	@Override
	public Response registraVenta(FacturacionDto fact) {
		// TODO Auto-generated method stub
		return null;
	}

	
}