package org.pos.core.dao;

import org.pos.core.mapper.PerfilesMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PerfilesMapper.class)
public interface PerfilesDao extends DaoInterface {
	    
}