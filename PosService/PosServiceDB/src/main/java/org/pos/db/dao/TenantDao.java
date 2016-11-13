package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.TenantMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TenantMapper.class)
public interface TenantDao extends DaoInterface {
	
	
	
}