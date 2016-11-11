package org.pos.db.dao;

import org.pos.db.mapper.AlmacenProductoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(AlmacenProductoMapper.class)
public interface AlmacenProductoDao extends DaoInterface {
	    
}