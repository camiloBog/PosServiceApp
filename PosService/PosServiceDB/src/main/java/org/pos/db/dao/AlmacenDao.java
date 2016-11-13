package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.AlmacenMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(AlmacenMapper.class)
public interface AlmacenDao extends DaoInterface {
	    
}