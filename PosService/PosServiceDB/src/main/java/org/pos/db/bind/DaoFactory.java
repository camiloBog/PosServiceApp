package org.pos.db.bind;

import org.pos.db.dao.DetalleMovimientoDao;
import org.pos.db.dao.MovimientoDao;
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
		return DbiProvider.getDBI(esquema).open(UsuarioDao.class);
	}
	public static UsuarioDao getUsuarioDao(Class<UsuarioDao> daoClass) {
		return DbiProvider.getDBI().open(UsuarioDao.class);
	}

	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(DetalleMovimientoDao.class);
	}
	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass) {
		return DbiProvider.getDBI().open(DetalleMovimientoDao.class);
	}

	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(MovimientoDao.class);
	}
	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass) {
		return DbiProvider.getDBI().open(MovimientoDao.class);
	}
	

	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(PerfilesDao.class);
	}
	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass) {
		return DbiProvider.getDBI().open(PerfilesDao.class);
	}
	

	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(PersonaDao.class);
	}
	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass) {
		return DbiProvider.getDBI().open(PersonaDao.class);
	}
	

	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(ProductoDao.class);
	}
	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass) {
		return DbiProvider.getDBI().open(ProductoDao.class);
	}
	

	public static TenantDao getTenantDao(Class<TenantDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(TenantDao.class);
	}
	public static TenantDao getTenantDao(Class<TenantDao> daoClass) {
		return DbiProvider.getDBI().open(TenantDao.class);
	}
	

	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(TipoIdentificacionDao.class);
	}
	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass) {
		return DbiProvider.getDBI().open(TipoIdentificacionDao.class);
	}
	

	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(TipoMedidaDao.class);
	}
	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass) {
		return DbiProvider.getDBI().open(TipoMedidaDao.class);
	}
	

	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(TipoMovimientoDao.class);
	}
	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass) {
		return DbiProvider.getDBI().open(TipoMovimientoDao.class);
	}
	

	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).open(TipoPersonasDao.class);
	}
	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass) {
		return DbiProvider.getDBI().open(TipoPersonasDao.class);
	}

}
