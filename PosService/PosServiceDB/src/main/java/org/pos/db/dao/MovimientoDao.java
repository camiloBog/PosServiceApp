package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.MovimientoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(MovimientoMapper.class)
public interface MovimientoDao extends DaoInterface {
	    
}