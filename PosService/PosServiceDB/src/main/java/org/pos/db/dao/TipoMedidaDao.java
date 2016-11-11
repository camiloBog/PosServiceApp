package org.pos.db.dao;

import org.pos.db.mapper.TipoMedidaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMedidaMapper.class)
public interface TipoMedidaDao extends DaoInterface {
	    
}