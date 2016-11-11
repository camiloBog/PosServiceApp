package org.pos.db.dao;

import org.pos.db.mapper.CiudadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(CiudadMapper.class)
public interface DetalleMovimientoDao extends DaoInterface {
	    
}