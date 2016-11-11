package org.pos.db.dao;

import org.pos.db.mapper.TipoPersonasMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoPersonasMapper.class)
public interface TipoPersonasDao  extends DaoInterface{
	    
}