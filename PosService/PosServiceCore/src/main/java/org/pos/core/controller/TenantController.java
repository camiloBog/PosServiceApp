package org.pos.core.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.TenantDao;
import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.Usuarios;

public class TenantController {
	
	private Logger log = LogManager.getLogger(TenantController.class);

	public MsgResponseDto registra(String tipoidentificacion, String identificacion, 
			String nombre, String direccion, String telefono) {

		TenantDao dao = null;
		Tenant tenant = new Tenant();
		String esquemaName = "";
		
		try {
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			Tenant t = dao.findByIdentificacion(identificacion);
			if(null!=t)
				return new MsgResponseDto("Ya existe un Tenant con la identificacion: "+identificacion, false, null);
			
			int tipoId = new TiposController().getTipoIdentificacion(tipoidentificacion).getIdidentificacion();
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			esquemaName = getTenantName(nombre);
			
			tenant.setIdentificacion(identificacion);
			tenant.setNombre(nombre);
			tenant.setTelefono(telefono);
			tenant.setDireccion(direccion);
			tenant.setTipoidentificacion(tipoId);

			int id = -1;
			id = dao.generarTenant(tenant, esquemaName);
			
			if (id!=-1) {
				log.info("Tenant creado!");
				return new MsgResponseDto("Tenant Creado Exitosamente con el Codigo: "+id, true, null);
			} else {
				return new MsgResponseDto("No fue posible generar el Tenant", false, null);
			}
			
		} catch (Exception e) {
			log.error("Ocurrio un error al realizar la creacion del tenan. " + e.getMessage() );
			//e.printStackTrace();
			return new MsgResponseDto("Ocurrio un error al realizar la creacion del tenan.",false,null);
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}
	
	public MsgResponseDto findByIdentificacion(String id) {
		
		TenantDao dao = null;
		Tenant tenant = null;
		
		try {
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			tenant = dao.findByIdentificacion(id);
			
			if(tenant!=null){
				tenant.setEsquema(null);
				return new MsgResponseDto("", true, tenant);
			} else {
				return new MsgResponseDto("No se encontro un tenant con el Id: "+id ,false,null);
			}
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del tenant. " + e.getMessage() );
			return new MsgResponseDto("Ocurrio un error al realizar la consulta del tenant.",false,null);
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}
	
	public Tenant findByIdTenant(String id) {
		
		TenantDao dao = null;
		Tenant tenant = null;
		
		try {
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			tenant = dao.findByIdTenant(Integer.parseInt(id));
			return tenant;
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del tenant. " + e.getMessage() );
			return null;
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}
	
	public Tenant findByUsuario(Usuarios usuario) {
		
		TenantDao dao = null;
		Tenant tenant = null;
		
		try {
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			tenant = dao.findByIdTenant(usuario.getIdtenant());
			
			return tenant;
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del tenant por usuario. ");
			log.error(e.getMessage());
			return null;
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}
	
	public MsgResponseDto BuscaTenantByCod(String cod) {
		
		TenantDao dao = null;
		Tenant tenant = null;
		
		try {
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			tenant = dao.findByIdTenant(Integer.parseInt(cod));
			
			if(tenant!=null){
				tenant.setEsquema(null);
				return new MsgResponseDto("", true, tenant);
			} else {
				return new MsgResponseDto("No se encontro un tenant con el Codigo: "+cod ,false,null);
			}
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del tenant. " + e.getMessage() );
			return new MsgResponseDto("Ocurrio un error al realizar la consulta del tenant.",false,null);
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}
	
	public String getEsquema(String usuario){
		
		try {
			
			Usuarios usu = new UsuarioController().findByUsuario(usuario);
			Tenant tenant = new TenantController().findByUsuario(usu);
						
			return tenant.getEsquema();
			
		} catch (Exception e) {
			log.error("Ocurrio un error obtener el esquema del usuario " + usuario);
			log.error(e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * Se encarga de acondicionar el nombre del tenant de acuerdo
	 * al nombre del cliente y el id del tenant.
	 * 
	 * @param name	Nombre del cliente
	 * 
	 * @return
	 */
	private String getTenantName(String name){
		
		name = name.replaceAll(" ", "");
		name = name.replaceAll("-", "");

		 // Cadena de caracteres original a sustituir.
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    // Cadena de caracteres ASCII que reemplazarán los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";

        // Reemplazamos los caracteres especiales.
	    for (int i=0; i<original.length(); i++)
	    	name = name.replace(original.charAt(i), ascii.charAt(i));
	    
	    String numeros = "0123456789";
	    for (int i = 0; i < numeros.length(); i++)
	    	name = name.replaceAll(numeros.charAt(i) +"", "");
	    
	    String caracteres = "_@#$%^&=`~]}//|\"':;,><";
	    for (int i = 0; i < caracteres.length(); i++)
	    	name = name.replaceAll(caracteres.charAt(i) +"", "");
	    
		return name;
	}
	
}
