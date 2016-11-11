package org.pos.db.dao;

import org.pos.db.mapper.ModuloMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ModuloMapper.class)
public interface ModuloDao extends DaoInterface {
	    
}