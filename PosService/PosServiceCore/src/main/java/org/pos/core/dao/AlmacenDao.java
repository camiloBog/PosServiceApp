package org.pos.core.dao;

import org.pos.core.mapper.AlmacenMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(AlmacenMapper.class)
public interface AlmacenDao extends DaoInterface {
	    
}