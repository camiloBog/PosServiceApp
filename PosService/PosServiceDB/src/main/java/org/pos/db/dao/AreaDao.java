package org.pos.db.dao;

import org.pos.db.mapper.AreaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(AreaMapper.class)
public interface AreaDao extends DaoInterface {
	    
}