package org.pos.core.dao;

import org.pos.core.mapper.AreaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(AreaMapper.class)
public interface AreaDao extends DaoInterface {
	    
}