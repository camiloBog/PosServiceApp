package org.pos.rest.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.core.dto.LoginRequestDto;
import org.pos.core.dto.LoginResponseDto;

@Path("prueba")
public class ClaseDePrueba {

	public ClaseDePrueba() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Path("usu")
	@Produces(MediaType.APPLICATION_JSON)
	public Response algo(LoginRequestDto req){
		
		System.out.println("Ha llegado al servicio Rest!");
		System.out.println("Usuario: "+req.getUsuario());
		
		LoginResponseDto resp = new LoginResponseDto();
		resp.setMensaje("PRueba OK!!");
		resp.setValidacion(true);
		
		return Response.status(200).entity(resp).build();
	}
	


}
