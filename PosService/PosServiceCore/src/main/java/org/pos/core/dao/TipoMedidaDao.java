package org.pos.core.dao;

import org.pos.core.mapper.TipoMedidaMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMedidaMapper.class)
public interface TipoMedidaDao extends DaoInterface {
	    
}