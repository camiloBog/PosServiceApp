package org.pos.core.dao;

import org.pos.core.mapper.TipoPersonasMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoPersonasMapper.class)
public interface TipoPersonasDao  extends DaoInterface{
	    
}