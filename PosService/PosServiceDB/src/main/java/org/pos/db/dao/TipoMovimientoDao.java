package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.TipoMovimientoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMovimientoMapper.class)
public interface TipoMovimientoDao extends DaoInterface{
	    
}