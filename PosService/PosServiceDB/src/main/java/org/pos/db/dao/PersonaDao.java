package org.pos.db.dao;

import org.pos.db.mapper.PersonaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PersonaMapper.class)
public interface PersonaDao extends DaoInterface {
	    
}