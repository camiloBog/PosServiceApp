package org.pos.core.dao;

import org.pos.core.mapper.TipoIdentificacionMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoIdentificacionMapper.class)
public interface TipoIdentificacionDao extends DaoInterface {
	    
}