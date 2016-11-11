package org.pos.db.bind;

import org.pos.db.dao.AlmacenDao;
import org.pos.db.dao.AlmacenProductoDao;
import org.pos.db.dao.AreaDao;
import org.pos.db.dao.CiudadDao;
import org.pos.db.dao.DetalleMovimientoDao;
import org.pos.db.dao.FuncionalidadDao;
import org.pos.db.dao.ModuloDao;
import org.pos.db.dao.MovimientoDao;
import org.pos.db.dao.PerfilFuncionalidadDao;
import org.pos.db.dao.PerfilesDao;
import org.pos.db.dao.PersonaDao;
import org.pos.db.dao.ProductoDao;
import org.pos.db.dao.TenantDao;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.dao.TipoMedidaDao;
import org.pos.db.dao.TipoMovimientoDao;
import org.pos.db.dao.TipoPersonasDao;
import org.pos.db.dao.UsuarioDao;

public class DaoFactory {

	private DaoFactory() {
		
	}

	public static UsuarioDao getUsuarioDao(Class<UsuarioDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(UsuarioDao.class);
	}

	public static AlmacenDao getAlmacenDao(Class<AlmacenDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(AlmacenDao.class);
	}

	public static AlmacenProductoDao getAlmacenProductoDao(Class<AlmacenProductoDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(AlmacenProductoDao.class);
	}

	public static AreaDao getAreaDaoget(Class<AreaDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(AreaDao.class);
	}

	public static CiudadDao getCiudadDao(Class<CiudadDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(CiudadDao.class);
	}

	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(DetalleMovimientoDao.class);
	}

	public static FuncionalidadDao getFuncionalidadDao(Class<FuncionalidadDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(FuncionalidadDao.class);
	}

	public static ModuloDao get(Class<ModuloDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(ModuloDao.class);
	}

	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(MovimientoDao.class);
	}

	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(PerfilesDao.class);
	}

	public static PerfilFuncionalidadDao getPerfilFuncionalidadDao(Class<PerfilFuncionalidadDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(PerfilFuncionalidadDao.class);
	}

	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(PersonaDao.class);
	}

	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(ProductoDao.class);
	}

	public static TenantDao getTenantDao(Class<TenantDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(TenantDao.class);
	}

	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(TipoIdentificacionDao.class);
	}

	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(TipoMedidaDao.class);
	}

	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(TipoMovimientoDao.class);
	}

	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass, String esquema) {
		return DbiSingleton.getDBI(esquema).open(TipoPersonasDao.class);
	}

}
