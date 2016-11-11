package org.pos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.Usuario;
import org.pos.dto.LoginResponseDto;
import org.pos.dto.MenuDto;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("loginsrv")
public class LoginSrv {

	private static final Logger log = LogManager.getLogger(LoginSrv.class);
	
	@GET
	@Path("validar/{usu}/{pas}/{esquema}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valida(
			@PathParam("usu") String usuario, 
			@PathParam("pas") String pass,
			@PathParam("esquema") String esquema) {
		
		log.info("Validando usuario...");
		
		UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class, esquema);
		Usuario usu = null;
		
		System.out.println("Validando: "+usuario+" "+pass);
		
		try {
			usu = dao.validate(usuario, pass);
		} catch (Exception e) {
			System.out.println("Falló la validacion! " + e.getLocalizedMessage());
			e.printStackTrace();
		}finally {
			dao.close();
		}

		LoginResponseDto rs = new LoginResponseDto();
		if( null!=usu ){
			System.out.println("Usuario OK!");
			rs.setNombre(usu.getNombre() + " " + usu.getApellidos());
			rs.setTenant(usu.getIdtenant());
			rs.setUsuario(usu.getUsuario());
			rs.setValidacion(true);
			rs.setMensaje("Bienvenido " + usu.getNombre());
			rs.setMenu(new MenuDto(true));
			
		}else{
			System.out.println("Usuario NULL!");
//			rs.setNombre("");
//			rs.setTenant(null);
//			rs.setUsuario("");
//			rs.setValidacion(false);
//			rs.setMensaje("Usuario y/o contraseña incorrectos, intentalo de nuevo.");
			
			rs = null;
		}
		
		return Response.status(200).entity(rs).build();
		//return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").entity(rs).build();
	}
	

}