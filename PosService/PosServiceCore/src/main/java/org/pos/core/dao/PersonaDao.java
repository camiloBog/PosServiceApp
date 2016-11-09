package org.pos.core.dao;

import org.pos.core.mapper.PersonaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PersonaMapper.class)
public interface PersonaDao extends DaoInterface {
	    
}