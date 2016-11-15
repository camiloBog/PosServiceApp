package org.pos.core.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.entidades.TipoIdentificacion;

public class TiposController {
	
	Logger log = LogManager.getLogger(TiposController.class);

	public TiposController() {
		
	}
	
	public List<TipoIdentificacion> getAllTipoIdentificacion(){
		
		TipoIdentificacionDao dao = null;
		List<TipoIdentificacion> tipos = null;
		
		try {
			dao = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			
			tipos = dao.findAll();
			return tipos;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al obtener todos los tipos de usuario.");
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
	}
	
	/**
	 * Se encarga de recuperar un tipo de identificacion a partir del id
	 * @param tipo
	 * @return
	 */
	public TipoIdentificacion getTipoIdentificacion(String id){
		
		TipoIdentificacionDao dao = null;
		TipoIdentificacion tipoId = null;
		
		try {
			dao = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			
			Integer tipo_ = Integer.parseInt(id);
			tipoId = dao.getTipoById(tipo_);
			return tipoId;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al encontrar el tipo de usuario " + id);
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
	}

}
