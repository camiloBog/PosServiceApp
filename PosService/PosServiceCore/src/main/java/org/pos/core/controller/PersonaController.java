package org.pos.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.PersonaDao;
import org.pos.db.dao.QueryDinamicoDao;
import org.pos.db.entidades.Persona;


public class PersonaController {
	
	private Logger log = LogManager.getLogger(PersonaController.class);

	public MsgResponseDto registra(Persona persona) {
		
		PersonaDao dao = null;
		String usuario = persona.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+persona.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getPersonaDao(PersonaDao.class, esquema);

			int id = -1;
			id = dao.creaPersona(persona);
			
			if (id!=-1)
				return new MsgResponseDto(persona.getNombre()+" fue registrado con el id: " +id,true,null);
			else
				return new MsgResponseDto("No fue posible realizar el registro!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar la persona " + persona.getNombre());
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al realizar el registro!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
		
	}

	public MsgResponseDto buscar(Persona persona) {
		
		String usuario = persona.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+persona.getUsuario()+" no existe.",false,null);
			
			List<Persona> productos = new QueryDinamicoDao().buscaPersona(persona, esquema);
			
			if (null!=productos && 0!=productos.size())
				return new MsgResponseDto("Se encontraron "+productos.size()+" registros",true, productos);
			else
				return new MsgResponseDto("No se encontraron registros!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar la persona " + persona.getNombre());
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar el registro!",false,null);
		}
		
	}

	public MsgResponseDto eliminar(Persona persona) {
		
		PersonaDao dao = null;
		String usuario = persona.getUsuario();
		String nombrePersona = persona.getNombre();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+persona.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getPersonaDao(PersonaDao.class, esquema);
			dao.deleteById(persona);
			
			return new MsgResponseDto("Registro "+nombrePersona+" borrado exitosamente!",true,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al borrar el registro " + nombrePersona);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al borrar el registro!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}		
		
	}
	
}
