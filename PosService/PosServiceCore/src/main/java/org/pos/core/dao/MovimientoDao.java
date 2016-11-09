package org.pos.core.dao;

import org.pos.core.mapper.MovimientoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(MovimientoMapper.class)
public interface MovimientoDao extends DaoInterface {
	    
}