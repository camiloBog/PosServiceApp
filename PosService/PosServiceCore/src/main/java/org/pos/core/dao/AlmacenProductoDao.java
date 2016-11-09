package org.pos.core.dao;

import org.pos.core.mapper.AlmacenProductoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(AlmacenProductoMapper.class)
public interface AlmacenProductoDao extends DaoInterface {
	    
}