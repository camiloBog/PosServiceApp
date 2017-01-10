package org.pos.core.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.bind.DbiProvider;
import org.pos.db.dao.ProductoDao;
import org.pos.db.entidades.Producto;
import org.pos.db.mapper.ProductoMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;


public class ProductoController {
	
	private Logger log = LogManager.getLogger(ProductoController.class);
	
	public MsgResponseDto buscarProducto(Producto producto) {
		
		String usuario = producto.getUsuario();
		Handle handle = null;
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+producto.getUsuario()+" no existe.",false,null);
			
			String sql = "SELECT * FROM "+esquema+".PRODUCTOS WHERE ";
			
			if(null!=producto.getIdproducto())
				sql += "IDPRODUCTO = ? AND ";
			else if(null!=producto.getIdtipomedida())
				sql += "IDTIPOMEDIDA = ? AND ";
			else if(null!=producto.getNombreproducto() && !"".equals(producto.getNombreproducto()))
				sql += "LOWER(NOMBREPRODUCTO) LIKE LOWER(?) AND ";
			else if(null!=producto.getDescripcion() && !"".equals(producto.getDescripcion()))
				sql += "LOWER(DESCRIPCION) LIKE LOWER(?) AND ";
			sql += "1=1";
			
			log.info("Buscando producto...");
			log.info("Query: " + sql);
			
			DBI dbi = DbiProvider.getSimpleDBI();
			handle = dbi.open();
			
			Query<Map<String, Object>> query = handle.createQuery(sql);
			int position = 1;
			if(null!=producto.getIdproducto()){
				query.bind(position, producto.getIdproducto());
				position++;
			}else if(null!=producto.getIdtipomedida()){
				query.bind(position, producto.getIdtipomedida());
				position++;
			}else if(null!=producto.getNombreproducto() && !"".equals(producto.getNombreproducto())){
				query.bind(position, producto.getNombreproducto());
				position++;
			}else if(null!=producto.getDescripcion() && !"".equals(producto.getDescripcion())){
				query.bind(position, producto.getDescripcion());
				position++;
			}
			
//			List<Producto> productos = handle.createQuery(sql).map(new ProductoMapper()).list();
			List<Producto> productos = query.map(new ProductoMapper()).list();
			
			if (null!=productos && 0!=productos.size())
				return new MsgResponseDto("Se encontraron "+productos.size()+" productos",true,productos);
			else
				return new MsgResponseDto("No se encontraron productos!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar el producto!",false,null);
		}finally{
			if(null!=handle)
				handle.close();
		}
		
	}
	
	public MsgResponseDto buscarProducto_BACKUP(Producto producto) {
		
		ProductoDao dao = null;
		String usuario = producto.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+producto.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getProductoDao(ProductoDao.class, esquema);
			
			List<Producto> productos = dao.findAll();

			if (null!=productos && 0!=productos.size())
				return new MsgResponseDto("Se encontraron "+productos.size()+" productos",true,productos);
			else
				return new MsgResponseDto("No se encontraron productos!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar el producto!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
		
	}
	
	public MsgResponseDto buscarPorDescri(Producto producto) {
		
		ProductoDao dao = null;
		String usuario = producto.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+producto.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getProductoDao(ProductoDao.class, esquema);
			List<Producto> productos = dao.findByDescri(producto);
						
			if (null!=productos)
				return new MsgResponseDto("Se encontraron "+productos.size()+" productos",true,productos);
			else
				return new MsgResponseDto("No Se encontraron productos con estas caracteristicas!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar el producto!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
	}

	public MsgResponseDto registra(Producto producto) {
		
		ProductoDao dao = null;
		String usuario = producto.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+producto.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getProductoDao(ProductoDao.class, esquema);

			int id = -1;
			id = dao.creaProducto(producto);
			
			if (id!=-1)
				return new MsgResponseDto("Producto "+producto.getNombreproducto()+" registrado con el id: " +id,true,null);
			else
				return new MsgResponseDto("No fue posible registrar el producto!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el producto " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al registrar el producto!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
	}

	public MsgResponseDto eliminar(Producto producto) {
		
		ProductoDao dao = null;
		String usuario = producto.getUsuario();
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+producto.getUsuario()+" no existe.",false,null);
			
			dao = DaoFactory.getProductoDao(ProductoDao.class, esquema);
			dao.deleteById(producto.getIdproducto());
			
			return new MsgResponseDto("Producto "+producto.getNombreproducto()+" borrado exitosamente!",true,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al borrar el producto " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al borrar el producto!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
		
	}
	
}
