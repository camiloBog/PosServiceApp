package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Perfiles;
import org.pos.db.mapper.PerfilesMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PerfilesMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface PerfilesDao extends DaoInterface {
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".PERFILES where idperfil = :idperfil")
	public Perfiles findById(@Bind("idperfil") int idperfil);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".PERFILES")
	public List<Perfiles> findAll();
	    
}