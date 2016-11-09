package org.pos.core.bind;

import org.pos.core.dao.AlmacenDao;
import org.pos.core.dao.AlmacenProductoDao;
import org.pos.core.dao.AreaDao;
import org.pos.core.dao.CiudadDao;
import org.pos.core.dao.DetalleMovimientoDao;
import org.pos.core.dao.FuncionalidadDao;
import org.pos.core.dao.ModuloDao;
import org.pos.core.dao.MovimientoDao;
import org.pos.core.dao.PerfilFuncionalidadDao;
import org.pos.core.dao.PerfilesDao;
import org.pos.core.dao.PersonaDao;
import org.pos.core.dao.ProductoDao;
import org.pos.core.dao.TenantDao;
import org.pos.core.dao.TipoIdentificacionDao;
import org.pos.core.dao.TipoMedidaDao;
import org.pos.core.dao.TipoMovimientoDao;
import org.pos.core.dao.TipoPersonasDao;
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

	public static AlmacenProductoDao getAlmacenProductoDao(Class<AlmacenProductoDao> daoClass) {
		return DbiSingleton.getDBI().open(AlmacenProductoDao.class);
	}

	public static AreaDao getAreaDaoget(Class<AreaDao> daoClass) {
		return DbiSingleton.getDBI().open(AreaDao.class);
	}

	public static CiudadDao getCiudadDao(Class<CiudadDao> daoClass) {
		return DbiSingleton.getDBI().open(CiudadDao.class);
	}

	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass) {
		return DbiSingleton.getDBI().open(DetalleMovimientoDao.class);
	}

	public static FuncionalidadDao getFuncionalidadDao(Class<FuncionalidadDao> daoClass) {
		return DbiSingleton.getDBI().open(FuncionalidadDao.class);
	}

	public static ModuloDao get(Class<ModuloDao> daoClass) {
		return DbiSingleton.getDBI().open(ModuloDao.class);
	}

	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass) {
		return DbiSingleton.getDBI().open(MovimientoDao.class);
	}

	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass) {
		return DbiSingleton.getDBI().open(PerfilesDao.class);
	}

	public static PerfilFuncionalidadDao getPerfilFuncionalidadDao(Class<PerfilFuncionalidadDao> daoClass) {
		return DbiSingleton.getDBI().open(PerfilFuncionalidadDao.class);
	}

	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass) {
		return DbiSingleton.getDBI().open(PersonaDao.class);
	}

	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass) {
		return DbiSingleton.getDBI().open(ProductoDao.class);
	}

	public static TenantDao getTenantDao(Class<TenantDao> daoClass) {
		return DbiSingleton.getDBI().open(TenantDao.class);
	}

	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass) {
		return DbiSingleton.getDBI().open(TipoIdentificacionDao.class);
	}

	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass) {
		return DbiSingleton.getDBI().open(TipoMedidaDao.class);
	}

	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass) {
		return DbiSingleton.getDBI().open(TipoMovimientoDao.class);
	}

	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass) {
		return DbiSingleton.getDBI().open(TipoPersonasDao.class);
	}

}
