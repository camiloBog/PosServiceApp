package org.pos.core.dao;

import org.pos.core.mapper.TenantMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TenantMapper.class)
public interface TenantDao extends DaoInterface {
	    
}