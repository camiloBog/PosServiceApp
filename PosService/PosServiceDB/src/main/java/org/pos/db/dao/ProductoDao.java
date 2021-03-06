package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Producto;
import org.pos.db.mapper.ProductoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ProductoMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public abstract class ProductoDao {

	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".PRODUCTO (idproducto, nombreproducto, descripcion, idtipomedida, precioventa, existencias) "
			+ "values (:idproducto, :nombreproducto, :descripcion, :idtipomedida, :precioVenta, :existencias)")
	protected abstract void insert(@BindBean Producto producto);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".PRODUCTO where idproducto = :idproducto")
	public abstract void deleteById(@Bind("idproducto") int idproducto);
	
	@SqlUpdate("update "+PosSGlobal.ESQUEMA+".PRODUCTO set existencias = :existencias where idproducto = :idproducto")
	public abstract void setCantidad(@Bind("idproducto") int idproducto, @Bind("existencias") int existencias);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".PRODUCTO where idproducto = :idproducto")
	public abstract Producto findById(@Bind("idproducto") int idproducto);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".PRODUCTO order by nombreproducto")
	public abstract List<Producto> findAll();
	
	@SqlQuery("select p.* from "+PosSGlobal.ESQUEMA+".PRODUCTO p where lower(p.nombreproducto) like lower('%'||:nombreproducto||'%')" )
	public abstract List<Producto> findByNombre(@BindBean Producto producto);
	
	@SqlQuery("select p.* from "+PosSGlobal.ESQUEMA+".PRODUCTO p where lower(p.descripcion) like lower('%'||:descripcion||'%') " )
	public abstract List<Producto> findByDescri(@BindBean Producto producto);

	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".producto_seq')")
	protected abstract int getSecuence();
	
	public abstract void close();
	
	@Transaction
	public int creaProducto(Producto producto) {
		int id = getSecuence();
		producto.setIdproducto(id);
		insert(producto);
		return id;
	}
	
}