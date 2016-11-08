package org.pos.rest;


import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.core.entidades.Usuario;


@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		System.out.println("Llego al Rest!!");
		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
	
	@GET
	@Path("getusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario() {
		
		System.out.println("Consulta " + new Date() );
		
		Usuario usu = new Usuario();
		usu.setNombre("Camilo");
		usu.setApellidos("Bustamante");
		
		return usu;
	}

}
