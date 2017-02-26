package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Persona;
import org.pos.db.mapper.PersonaMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PersonaMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public abstract class PersonaDao{
	
	
	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".PERSONA (idpersona, idtipopersona, idtipoidentificacion, "
			+ "identificacion, nombre, direccion, telefono, correocontacto, contacto) "
			+ "values (:idpersona, :idtipopersona, :idtipoidentificacion, :identificacion, :nombre, :direccion, "
			+ ":telefono, :correocontacto, :contacto)")
	protected abstract void insert(@BindBean Persona persona);
	
	@SqlQuery("select p.* from "+PosSGlobal.ESQUEMA+ ".PERSONA p where identificacion = :identificacion and "
			+ "idtipoidentificacion = :idtipoidentificacion and idtipopersona = :idtipopersona")
	public abstract List<Persona> getPersona(@BindBean Persona persona);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".PERSONA where idpersona = :idpersona")
	public abstract void deleteById(@BindBean Persona persona);
	
	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".persona_seq')")
	public abstract int getSecuence();
	
	public abstract void close();
	
	@Transaction
	public int creaPersona(Persona persona) {
		int id = getSecuence();
		persona.setIdpersona(id);
		insert(persona);
		return id;
	}
	
}