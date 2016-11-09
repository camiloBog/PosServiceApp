package org.pos.core.bind;

import org.pos.core.dao.AlmacenDao;
import org.pos.core.dao.UsuarioDao;

public class DaoFactory {
	
	private DaoFactory() {
	}

	public static UsuarioDao getUsuarioDao(Class<UsuarioDao> daoClass) {
		return DbiSingleton.getDBI().open(UsuarioDao.class);
	}
	
	public static AlmacenDao getAlmacenDao(Class<AlmacenDao> daoClass) {
		return DbiSingleton.getDBI().open(AlmacenDao.class);
	}



}
