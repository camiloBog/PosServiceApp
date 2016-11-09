package org.pos.core.dao;

import org.pos.core.mapper.TipoMovimientoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMovimientoMapper.class)
public interface TipoMovimientoDao extends DaoInterface{
	    
}