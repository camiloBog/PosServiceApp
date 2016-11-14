package org.pos.core.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.entidades.TipoIdentificacion;

public class TiposController {
	
	Logger log = LogManager.getLogger(TiposController.class);

	public TiposController() {
		
	}
	
	public TipoIdentificacion getTipoIdentificacion(String tipo){
		
		TipoIdentificacionDao dao = null;
		TipoIdentificacion tipoId = null;
		
		try {
			dao = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			
			Integer tipo_ = Integer.parseInt(tipo);
			tipoId = dao.getTipoById(tipo_);
			return tipoId;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al encontrar el tipo de usuario " + tipo);
			e.printStackTrace();
			return null;
		}finally {
			dao.close();
		}
		
	}

}
