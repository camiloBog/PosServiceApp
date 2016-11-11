package org.pos.db.dao;

import org.pos.db.mapper.TipoIdentificacionMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoIdentificacionMapper.class)
public interface TipoIdentificacionDao extends DaoInterface {
	    
}