package org.pos.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.ProductoDao;
import org.pos.db.entidades.Producto;

public class ProductoController {
	
	private Logger log = LogManager.getLogger(ProductoController.class);
	
	public MsgResponseDto buscarProducto(Producto producto) {
		
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
	
}
