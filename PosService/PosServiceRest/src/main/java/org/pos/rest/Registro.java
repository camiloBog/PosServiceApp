package org.pos.rest;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pos.core.bind.DbService;
import org.pos.core.entidades.Area;
import org.pos.core.entidades.Tenant;
import org.pos.core.entidades.Usuario;


@Path("someservice")

public class Registro {
	
	@GET
	@Path("getipcliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIpCliente(@Context HttpServletRequest request ) {
		
		System.out.print("Consulta " + new Date() );
		
		String context = request.getContextPath();
		String host = request.getRemoteHost();
		String ip = request.getRemoteAddr();
		int port = request.getRemotePort();
		
		System.out.print(" context " + context );
		System.out.print(" host " + host );
		System.out.print(" ip " + ip );
		System.out.println(" port " + port );
		
		DbService db = new DbService();
		Usuario usu = db.getUsuario(1);
//		Usuario usu = new Usuario();
//		
//		usu.setNombre(db.getUsuario(1));
//		usu.setApellidos("HHHH SSS a");
		
//		usu.setNombre("Camilo");
//		usu.setApellidos("Bustamante Sanchez");
		
		return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").entity(usu).build();
	}

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
		usu.setApellidos("Bustamante  Sanchez");
		
		return usu;
	}
	
	@GET
	@Path("getTenant")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTenant() {
		
		System.out.println("Consulta " + new Date() );
		
		Tenant t = new Tenant();
		t.setDireccion("Calle Siempre viva");
		t.setEsquema("Algun esquema");
		t.setIdentificacion("80735633");
		t.setIdtenant(666);
		t.setNombre("Tenant Feo");
		t.setTelefono("3216633");
		t.setTipoidentificacion(555);
		
		Usuario usu = new Usuario();
		usu.setNombre("Camilo");
		usu.setApellidos("Bustamante  Sanchez");
		
		Area a = new Area();
		a.setDescripcion("Una localidad fea");
		a.setIdarea(8);
		usu.setContrasena("contraseñafea");
		usu.setIdusuario(8073);
		usu.setUsuario("Nombre feo de usuario");
		
		return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").entity(usu).build();
		
	}
	
	
	@GET
	@Path("getusuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		
		System.out.println("Consulta " + new Date() );
		
		Usuario usu = new Usuario();
		usu.setNombre("Camilo");
		usu.setApellidos("Bustamante");
		
		return Response.status(200).header("Access-Control-Allow-Origin", "http://localhost").entity(usu).build();
	}
	
	@POST
	@Path("postusuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUsuario(Usuario usu) {
		String resp = "EL usuario";
		return Response.status(201).entity(resp).build();
	}

}