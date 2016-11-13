package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.FuncionalidadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(FuncionalidadMapper.class)
public interface FuncionalidadDao extends DaoInterface {
	    
}