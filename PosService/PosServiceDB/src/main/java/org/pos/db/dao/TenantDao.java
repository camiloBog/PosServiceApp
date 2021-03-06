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

	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".TENANT (idtenant, tipoidentificacion, identificacion, nombre, direccion, telefono, esquema) "
			+ "values (:idtenant, :tipoidentificacion, :identificacion, :nombre, :direccion, :telefono, :esquema)")
	protected abstract void insert(@BindBean Tenant tenant);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".TENANT where idtenant = :idtenant")
	protected abstract void deleteById(@BindBean Tenant tenant);
	
	@SqlUpdate("select crearschema(:nombre)")
	protected abstract void setEsquema(@Bind("nombre") String nombre);
	
	@SqlUpdate("select eliminarschema(:nombre)")
	protected abstract void borrarEsquema(@Bind("nombre") String nombre);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TENANT where idtenant = :idtenant")
	public abstract Tenant findByIdTenant(@BindBean Tenant tenant);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".TENANT where identificacion = :identificacion")
	public abstract Tenant findByIdentificacion(@BindBean Tenant tenant);
		
	public abstract void close();
	
	@Transaction
	public int generarTenant(Tenant tenant, String esquemaName){
		
		int id = getSecuence();
		
		tenant.setIdtenant(id);
		tenant.setEsquema(esquemaName+"_"+id);
		
		insert(tenant);
		setEsquema(esquemaName+"_"+id);
		
		return id;
	}
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".USUARIOS where idtenant = :idtenant")
	protected abstract void borrarUsuarios(@Bind("idtenant") Integer idtenant);
	
	@Transaction
	public boolean eliminarTenant(Tenant tenant){
		
		tenant = findByIdTenant(tenant);
		borrarEsquema(tenant.getEsquema());
		borrarUsuarios(tenant.getIdtenant());
		deleteById(tenant);
		
		return true;
		
	}
	
}