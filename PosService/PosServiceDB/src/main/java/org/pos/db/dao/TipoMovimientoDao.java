package org.pos.db.dao;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.TipoMovimiento;
import org.pos.db.mapper.TipoMovimientoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMovimientoMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface TipoMovimientoDao extends DaoInterface{
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TipoMovimiento where idmovimiento = :id")
	public TipoMovimiento getTipoById(@Bind("id") String id);
	    
}