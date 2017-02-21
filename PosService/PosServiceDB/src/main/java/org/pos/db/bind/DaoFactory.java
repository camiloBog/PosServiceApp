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
		return DbiProvider.getDBI(esquema).onDemand(UsuarioDao.class);
	}
	public static UsuarioDao getUsuarioDao(Class<UsuarioDao> daoClass) {
		return DbiProvider.getDBI().onDemand(UsuarioDao.class);
	}

	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(DetalleMovimientoDao.class);
	}
	public static DetalleMovimientoDao getDetalleMovimientoDao(Class<DetalleMovimientoDao> daoClass) {
		return DbiProvider.getDBI().onDemand(DetalleMovimientoDao.class);
	}

	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(MovimientoDao.class);
	}
	public static MovimientoDao getMovimientoDao(Class<MovimientoDao> daoClass) {
		return DbiProvider.getDBI().onDemand(MovimientoDao.class);
	}
	

	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(PerfilesDao.class);
	}
	public static PerfilesDao getPerfilesDao(Class<PerfilesDao> daoClass) {
		return DbiProvider.getDBI().onDemand(PerfilesDao.class);
	}
	

	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(PersonaDao.class);
	}
	public static PersonaDao getPersonaDao(Class<PersonaDao> daoClass) {
		return DbiProvider.getDBI().onDemand(PersonaDao.class);
	}
	

	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(ProductoDao.class);
	}
	public static ProductoDao getProductoDao(Class<ProductoDao> daoClass) {
		return DbiProvider.getDBI().onDemand(ProductoDao.class);
	}
	

	public static TenantDao getTenantDao(Class<TenantDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(TenantDao.class);
	}
	public static TenantDao getTenantDao(Class<TenantDao> daoClass) {
		return DbiProvider.getDBI().onDemand(TenantDao.class);
	}
	

	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(TipoIdentificacionDao.class);
	}
	public static TipoIdentificacionDao getTipoIdentificacionDao(Class<TipoIdentificacionDao> daoClass) {
		return DbiProvider.getDBI().onDemand(TipoIdentificacionDao.class);
	}
	

	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(TipoMedidaDao.class);
	}
	public static TipoMedidaDao getTipoMedidaDao(Class<TipoMedidaDao> daoClass) {
		return DbiProvider.getDBI().onDemand(TipoMedidaDao.class);
	}
	

	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(TipoMovimientoDao.class);
	}
	public static TipoMovimientoDao getTipoMovimientoDao(Class<TipoMovimientoDao> daoClass) {
		return DbiProvider.getDBI().onDemand(TipoMovimientoDao.class);
	}
	

	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass, String esquema) {
		return DbiProvider.getDBI(esquema).onDemand(TipoPersonasDao.class);
	}
	public static TipoPersonasDao getTipoPersonasDao(Class<TipoPersonasDao> daoClass) {
		return DbiProvider.getDBI().onDemand(TipoPersonasDao.class);
	}

}
