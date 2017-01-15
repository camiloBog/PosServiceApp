package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.TipoMedida;
import org.pos.db.mapper.TipoMedidaMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoMedidaMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface TipoMedidaDao extends DaoInterface {
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TIPOMEDIDA where idtipomedida = :id")
	public TipoMedida getTipoById(@Bind("id") String id);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TIPOMEDIDA order by descripcion")
	public List<TipoMedida> findAll();
	    
}