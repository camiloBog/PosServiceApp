package org.pos.db.dao;

import org.pos.db.bind.DaoInterface;
import org.pos.db.mapper.PerfilFuncionalidadMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PerfilFuncionalidadMapper.class)
public interface PerfilFuncionalidadDao extends DaoInterface {
	    
}