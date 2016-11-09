package org.pos.core.dao;

import org.pos.core.mapper.ModuloMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ModuloMapper.class)
public interface ModuloDao extends DaoInterface {
	    
}