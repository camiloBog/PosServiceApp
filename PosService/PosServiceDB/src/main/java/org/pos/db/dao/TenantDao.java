package org.pos.db.dao;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Tenant;
import org.pos.db.mapper.TenantMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(TenantMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public abstract class TenantDao {

	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".tenant_seq')")
	public abstract int getSecuence();

	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".Tenant (idtenant, tipoidentificacion, identificacion, nombre, direccion, telefono, esquema) "
			+ "values (:idtenant, :tipoidentificacion, :identificacion, :nombre, :direccion, :telefono, :esquema)")
	public abstract void insert(@BindBean Tenant tenant);
	
	@SqlUpdate("select crearschema(:nombre)")
	public abstract void setEsquema(@Bind("nombre") String nombre);
	
	public abstract void close();
	
	@Transaction
	public void generarTenant(Tenant tenant, String esquemaName){
		
		int id = getSecuence();
		
		tenant.setIdtenant(id);
		tenant.setEsquema(esquemaName+"_"+id);
		
		insert(tenant);
		setEsquema(esquemaName+"_"+id);
		
	}
	
}