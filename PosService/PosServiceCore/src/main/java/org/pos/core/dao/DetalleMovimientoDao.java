package org.pos.core.dao;

import org.pos.core.mapper.CiudadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(CiudadMapper.class)
public interface DetalleMovimientoDao extends DaoInterface {
	    
}