package org.pos.core.dao;

import org.pos.core.mapper.FuncionalidadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(FuncionalidadMapper.class)
public interface FuncionalidadDao extends DaoInterface {
	    
}