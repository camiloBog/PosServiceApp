package org.pos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.core.bind.DaoFactory;
import org.pos.core.dao.UsuarioDao;
import org.pos.core.entidades.Usuario;
import org.pos.dto.LoginResponse;


@Path("loginsrv")
public class LoginSrv {
		
	@GET
	@Path("validar/{usu}/{pas}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valida(
			@PathParam("usu") String usuario, 
			@PathParam("pas") String pass) {
		
		UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
		Usuario usu = null;
		
		System.out.println("Validando: "+usuario+" "+pass);
		
		try {
			usu = dao.validate(usuario, pass);
		} catch (Exception e) {
			System.out.println("Fallo la validacion! " + e.getLocalizedMessage());
			e.printStackTrace();
		}finally {
			dao.close();
		}

		LoginResponse rs = new LoginResponse();
		if( null!=usu ){
			System.out.println("Usuario OK!");
			rs.setNombre(usu.getNombre() + " " + usu.getApellidos());
			rs.setTenant(usu.getIdtenant());
			rs.setUsuario(usu.getUsuario());
			rs.setValidacion(true);
			rs.setMensaje("Bienvenido " + usu.getNombre());
		}else{
			System.out.println("Usuario NULL!");
			rs.setNombre("");
			rs.setTenant(null);
			rs.setUsuario("");
			rs.setValidacion(false);
			rs.setMensaje("Usuario y/o contrase�a incorrectos, intentalo de nuevo.");
		}
		
		return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").entity(rs).build();
	}
	

}