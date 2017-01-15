package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.DetalleMovimiento;
import org.pos.db.entidades.Movimiento;
import org.pos.db.mapper.MovimientoMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(MovimientoMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public abstract class MovimientoDao {

	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".MOVIMIENTO (idmovimiento, idtipomovimiento, idpersona, fecha, idusuario) "
			+ "values (:idmovimiento, :idtipomovimiento, :idpersona, :fecha, :idusuario)")
	protected abstract int insert(@BindBean Movimiento movimiento);
	
	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".DETALLEMOVIMIENTO (idmovimiento, iddetalle, idproducto, cantidad, valor, observacion) "
			+ "values (:idmovimiento, :iddetalle, :idproducto, :cantidad, :valor, :observacion)")
	protected abstract int insertDetalle(@BindBean DetalleMovimiento detalleMovimiento);
	
	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".movimiento_seq')")
	protected abstract int getSecuence();
	
	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".detallemovimiento_seq')")
	protected abstract int getDetalleSecuence();
	
	public abstract void close();
	
	@Transaction
	public int creaMovimiento(Movimiento movimiento) {
		
		int idMov = getSecuence();
		movimiento.setIdmovimiento(idMov);
		insert(movimiento);
		
		List<DetalleMovimiento> list = movimiento.getDetallemovimiento();
		for (DetalleMovimiento detalle : list) {
			
			int idDetalle = getDetalleSecuence();
			
			detalle.setIddetalle(idDetalle);
			detalle.setIdmovimiento(movimiento.getIdmovimiento());
			
			insertDetalle(detalle);
		}

		return idMov;
	}
}