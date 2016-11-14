package org.pos.db.dao;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.TipoIdentificacion;
import org.pos.db.mapper.TipoIdentificacionMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TipoIdentificacionMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface TipoIdentificacionDao extends DaoInterface {

	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TipoIdentificacion where ididentificacion = :id")
	public TipoIdentificacion getTipoById(@Bind("id") Integer id);
	
	
}