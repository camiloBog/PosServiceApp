package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.DetalleMovimiento;
import org.pos.db.mapper.DetalleMovimientoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(DetalleMovimientoMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface DetalleMovimientoDao extends DaoInterface  {
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".DETALLEMOVIMIENTO where idmovimiento = :idmovimiento")
	public DetalleMovimiento findById(@Bind("idmovimiento") int idmovimiento);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".DETALLEMOVIMIENTO")
	public List<DetalleMovimiento> findAll();
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".DETALLEMOVIMIENTO where idmovimiento = :idmovimiento")
	public List<DetalleMovimiento> findAllById(@Bind("idmovimiento") int idmovimiento);
	
}