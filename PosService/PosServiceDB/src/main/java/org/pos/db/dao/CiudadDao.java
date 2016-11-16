package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.mapper.CiudadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(CiudadMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface CiudadDao extends DaoInterface{
	    
}