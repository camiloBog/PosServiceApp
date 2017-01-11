package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.TipoPersonas;
import org.pos.db.mapper.TipoPersonasMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoPersonasMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface TipoPersonasDao  extends DaoInterface{
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TipoPersonas where idtipopersona = :id")
	public TipoPersonas getTipoById(@Bind("id") String id);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TipoPersonas")
	public List<TipoPersonas> findAll();
	    
}