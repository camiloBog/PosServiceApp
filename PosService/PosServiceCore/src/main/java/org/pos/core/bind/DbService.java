package org.pos.core.bind;

import java.util.List;

import org.pos.core.dao.UsuarioDao;
import org.pos.core.entidades.Usuario;

public class DbService {

	public DbService() {

	}

	public void PruebaDaos() {

		System.out.println("Listo para hacer Pruebas!!!");

		UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
		// Usuario usu = dao.findById(1);
		// System.out.println("**** Pruebas: "+usu.getNombre());

		Usuario usu1 = new Usuario(1, "pp1", "Pedro", "PicaPicapiedra", "pp44asdf", 1, 1);
		Usuario usu2 = new Usuario(2, "cb2", "Camilo", "Bustamante", "1234", 1, 1);
		Usuario usu3 = new Usuario(3, "as3", "Andres", "Sanchez", "asww", 1, 1);
		Usuario usu4 = new Usuario(4, "jm4", "Juan", "Mendoza", "jmrtr", 1, 1);
		Usuario usu5 = new Usuario(5, "dt5", "Donalt", "Thrump", "dttthh", 1, 1);
		Usuario usu6 = new Usuario(6, "hc6", "Hilary", "Clinton", "hchgfj", 1, 1);

		dao.insert(usu1);
		dao.insert(usu2);
		dao.insert(usu3);
		dao.insert(usu4);
		dao.insert(usu5);
		dao.insert(usu6);

		// dao.close();

		// dao = (UsuarioDao) DaoFactory.getUsuarioDao(UsuarioDao.class);
		usu4.setApellidos("Apellido Modificado");
		dao.update(usu4);
		// dao.close();

		dao.deleteById(3);

		// dao = (UsuarioDao) DaoFactory.getUsuarioDao(UsuarioDao.class);
		System.out.println("**** Prueba usuarios:");
		List<Usuario> usuarios = dao.findAll();
		for (Usuario usuario : usuarios) {
			System.out.println("->" + usuario.getNombre() + " " + usuario.getApellidos());
		}

	}

	public Usuario getUsuario(int id) {

		Usuario usuario = null;
		UsuarioDao usuarioDao = null;

		try {
			usuarioDao = DbiSingleton.getDBI().open(UsuarioDao.class);
			usuario = usuarioDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("DATABASE SERVICE");
			usuarioDao.close();
		}

		return usuario;

	}

}