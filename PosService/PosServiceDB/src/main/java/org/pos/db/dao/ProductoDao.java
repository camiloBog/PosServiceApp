package org.pos.db.dao;

import org.pos.db.mapper.ProductoMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ProductoMapper.class)
public interface ProductoDao extends DaoInterface {
	    
}