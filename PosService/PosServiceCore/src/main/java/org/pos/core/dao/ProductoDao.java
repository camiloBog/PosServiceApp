package org.pos.core.dao;

import org.pos.core.mapper.ProductoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ProductoMapper.class)
public interface ProductoDao extends DaoInterface {
	    
}