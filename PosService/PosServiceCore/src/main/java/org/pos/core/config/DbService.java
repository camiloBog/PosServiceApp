package org.pos.core.config;

import org.pos.core.dao.UsuarioDao;
import org.pos.core.entidades.Usuario;
import org.skife.jdbi.v2.DBI;

public class DbService  {

	public DbService() {

	}
	
	public Usuario getUsuario(int id){
		
		DBI dbi = new DBI("jdbc:postgresql://127.0.0.1:5432/PosService", "postgres", "admin");
		
		Usuario usuario = null;
		UsuarioDao usuarioDao = null;
		
		try {
			usuarioDao = dbi.open(UsuarioDao.class);
			usuario = usuarioDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("DATABASE SERVICE");
			usuarioDao.close();
		}
		
		return usuario;

	}


}
