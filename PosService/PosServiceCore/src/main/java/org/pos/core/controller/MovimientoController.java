package org.pos.core.controller;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.MovimientoDao;
import org.pos.db.dao.PersonaDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.Movimiento;
import org.pos.db.entidades.Usuarios;


public class MovimientoController {
	
	private Logger log = LogManager.getLogger(MovimientoController.class);

	public MsgResponseDto registraIngreso(Movimiento movimiento) {
		
		MovimientoDao dao = null;
		UsuarioDao daoUsu = null;
		
		try {
			
			daoUsu = DaoFactory.getUsuarioDao(UsuarioDao.class);
			Usuarios usuario = daoUsu.findByUsuario(movimiento.getUsuario());
			if(null==usuario)
				return new MsgResponseDto("El usuario "+movimiento.getUsuario()+" no existe.",false,null);
			
			movimiento.setIdusuario(usuario.getIdusuario());
			movimiento.setFecha(new Timestamp(System.currentTimeMillis()));
			movimiento.setIdtipomovimiento(PosSGlobal.TIPO_COMPRA);
			
			String esquema = new TenantController().getEsquema(usuario.getUsuario());
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario.getUsuario()+" no existe.",false,null);

			dao = DaoFactory.getMovimientoDao(MovimientoDao.class, esquema);

			int id = -1;
			id = dao.creaMovimiento(movimiento);
			
			if (id!=-1)
				return new MsgResponseDto("El Movimiento fue registrado con el id: " +id,true,id);
			else
				return new MsgResponseDto("No fue posible realizar el registro!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el movimiento");
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al realizar el registro!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
		
	}
	
	

	

	
}
