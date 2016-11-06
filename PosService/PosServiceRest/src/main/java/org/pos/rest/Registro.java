package org.pos.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("someservice")

public class Registro {

	@GET
	@Path("getdate")
	@Produces(MediaType.TEXT_HTML)
	public Response getDate() {
		String date = null;
		Date currentDate = Calendar.getInstance().getTime();
		date = currentDate.toString();
		return Response.status(200).entity(date).build();
	}
	
	@GET
	@Path("getusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario() {
		
		System.out.println("Consulta " + new Date() );
		
		Usuario usu = new Usuario();
		usu.setNombre("Camilo");
		usu.setApellido("Bustamante");
		
		return usu;
	}
	
	@POST
	@Path("postusuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUsuario(Usuario usu) {
		String resp = "";
		return Response.status(201).entity(resp).build();
	}

}