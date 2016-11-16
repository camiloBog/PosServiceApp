package org.pos.core.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.ProductoDao;
import org.pos.db.entidades.Producto;

public class ProductoController {
	
	private Logger log = LogManager.getLogger(ProductoController.class);

	public ProductoController() {
		
	}

	public MsgResponseDto registra(String nombre, String descri, String medida, String usuario) {
		
		ProductoDao dao = null;
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario+" no existe.",false,null);
			
			dao = DaoFactory.getProductoDao(ProductoDao.class, esquema);
			
			Producto producto = new Producto();
			producto.setNombreproducto(nombre);
			producto.setDescripcion(descri);
			producto.setIdtipomedida(Integer.parseInt(medida));
			
			int id = -1;
			id = dao.creaProducto(producto);
			
			if (id!=-1) {
				return new MsgResponseDto("Producto "+nombre+" registrado con el id: " +id,true,null);
			} else {
				return new MsgResponseDto("No fue posible registrar el producto!",false,null);
			}
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el producto " + nombre);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al registrar el producto!",false,null);
		}finally{
			if(null!=dao)
				dao.close();
		}
		
	}

}
