package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.PerfilesMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PerfilesMapper.class)
public interface PerfilesDao extends DaoInterface {
	    
}