package org.pos.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.db.bind.DbiProvider;
import org.pos.db.entidades.Producto;
import org.pos.db.mapper.ProductoMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

public class GenericoDao {
	
	private Logger log = LogManager.getLogger(GenericoDao.class);

	public List<Producto> buscaProducto(Producto producto, String esquema) {
		
		String usuario = producto.getUsuario();
		Handle handle = null;

		try {

			String sql = "SELECT * FROM " + esquema + ".PRODUCTO WHERE ";

			if (null != producto.getIdproducto())
				sql += "IDPRODUCTO = :idproducto AND ";
			else if (null != producto.getIdtipomedida())
				sql += "IDTIPOMEDIDA = :idtipomedida AND ";
			else if (null != producto.getNombreproducto() && !"".equals(producto.getNombreproducto()))
				sql += "LOWER(NOMBREPRODUCTO) LIKE LOWER('%'||:nombreproducto||'%') AND ";
			else if (null != producto.getDescripcion() && !"".equals(producto.getDescripcion()))
				sql += "LOWER(DESCRIPCION) LIKE LOWER('%'||:descripcion||'%') AND ";
			sql += "1=1";

			DBI dbi = DbiProvider.getSimpleDBI();
			handle = dbi.open();

			Query<Map<String, Object>> query = handle.createQuery(sql);
			if (null != producto.getIdproducto()) {
				query.bind("idproducto", producto.getIdproducto());
			} else if (null != producto.getIdtipomedida()) {
				query.bind("idtipomedida", producto.getIdtipomedida());
			} else if (null != producto.getNombreproducto() && !"".equals(producto.getNombreproducto())) {
				query.bind("nombreproducto", producto.getNombreproducto());
			} else if (null != producto.getDescripcion() && !"".equals(producto.getDescripcion())) {
				query.bind("descripcion", producto.getDescripcion());
			}

			return query.map(new ProductoMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto " + usuario);
			log.error(e.getMessage());
			return null;
		} finally {
			if (null != handle)
				handle.close();
		}

	}

}
