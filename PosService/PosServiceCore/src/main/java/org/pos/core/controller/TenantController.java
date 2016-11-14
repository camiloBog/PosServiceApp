package org.pos.core.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.TenantDao;
import org.pos.db.entidades.Tenant;

public class TenantController {
	
	private Logger log = LogManager.getLogger(TenantController.class);

	public MsgResponseDto registra(String tipoidentificacion, String identificacion, 
			String nombre, String direccion, String telefono) {

		TenantDao dao = null;
		Tenant tenant = new Tenant();
		String esquemaName = "";
		
		try {
			
			int tipoId = new TiposController().getTipoIdentificacion(tipoidentificacion).getIdidentificacion();
			
			dao = DaoFactory.getTenantDao(TenantDao.class);
			esquemaName = getTenantName(nombre);
			
			tenant.setIdentificacion(identificacion);
			tenant.setNombre(nombre);
			tenant.setTelefono(telefono);
			tenant.setDireccion(direccion);
			tenant.setTipoidentificacion(tipoId);

			dao.generarTenant(tenant, esquemaName);
			
			log.info("Tenant creado!");
			return new MsgResponseDto("Tenant Creado Exitosamente",true,null);

		} catch (Exception e) {
			log.error("Ocurrio un error al realizar la creacion del tenan.");
			e.printStackTrace();
			
			return new MsgResponseDto("Ocurrio un error al realizar la creacion del tenan.",false,null);
		}finally {
			dao.close();
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
