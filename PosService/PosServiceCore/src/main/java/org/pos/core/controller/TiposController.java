package org.pos.core.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.PerfilesDao;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.entidades.Perfiles;
import org.pos.db.entidades.TipoIdentificacion;

public class TiposController {
	
	Logger log = LogManager.getLogger(TiposController.class);

	public TiposController() {
		
	}
	
	public List<Perfiles> getAllPerfiles(){
		
		PerfilesDao dao = null;
		List<Perfiles> perfiles = null;
		
		try {
			dao = DaoFactory.getPerfilesDao(PerfilesDao.class);
			
			perfiles = dao.findAll();
			return perfiles;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al obtener los perfiles de usuario.");
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
	}
	
	public Perfiles getPerfilById(int id){
		
		PerfilesDao dao = null;
		Perfiles perfil = null;
		
		try {
			dao = DaoFactory.getPerfilesDao(PerfilesDao.class);
			
			perfil = dao.findById(id);
			return perfil;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al encontrar el tipo de usuario " + id);
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
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
	public TipoIdentificacion getTipoIdentificacion(int tipoIdentificacion){
		
		TipoIdentificacionDao dao = null;
		TipoIdentificacion tipoId = null;
		
		try {
			dao = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			tipoId = dao.getTipoById(tipoIdentificacion);
			
			return tipoId;
			
		} catch (Exception e) {
			log.error("Ocurrio un error al encontrar el tipo de identificacion " + tipoIdentificacion);
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
	}

}
