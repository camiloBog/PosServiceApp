package org.pos.core.bind;

import org.pos.core.dao.UsuarioDao;
import org.pos.core.entidades.Usuario;

public class DbService  {

	public DbService() {

	}
	
	public Usuario getUsuario(int id){
		
		Usuario usuario = null;
		UsuarioDao usuarioDao = null;
		
		try {
			usuarioDao = DbiFactory.getDBI().open(UsuarioDao.class);
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
