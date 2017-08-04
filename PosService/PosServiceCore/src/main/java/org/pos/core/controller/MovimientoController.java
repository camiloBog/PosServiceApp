package org.pos.core.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.pos.core.dto.DetalleMovimientoDto;
import org.pos.core.dto.FacturacionDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.DetalleMovimientoDao;
import org.pos.db.dao.MovimientoDao;
import org.pos.db.dao.PersonaDao;
import org.pos.db.dao.ProductoDao;
import org.pos.db.dao.QueryDinamicoDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.DetalleMovimiento;
import org.pos.db.entidades.Movimiento;
import org.pos.db.entidades.Persona;
import org.pos.db.entidades.Producto;
import org.pos.db.entidades.Usuarios;


public class MovimientoController {
	
	private Logger log = LogManager.getLogger(MovimientoController.class);
	
	public MsgResponseDto consultaIngreso(Movimiento movimientoIn) {
		
		UsuarioDao daoUsu = null;
		DetalleMovimientoDao daoDetalle = null;
		ProductoDao daoProducto = null;
		
		try {
			
			daoUsu = DaoFactory.getUsuarioDao(UsuarioDao.class);
			Usuarios usuario = daoUsu.findByUsuario(movimientoIn.getUsuario());
			if(null==usuario)
				return new MsgResponseDto("El usuario "+movimientoIn.getUsuario()+" no existe.",false,null);

			String esquema = new TenantController().getEsquema(usuario.getUsuario());
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario.getUsuario()+" no existe.",false,null);

			
			Persona persona = new Persona();
			persona.setIdpersona(movimientoIn.getIdpersona());
			persona.setIdtipopersona(PosSGlobal.TIPO_PROVEEDOR);			
			List<Persona> personas = new QueryDinamicoDao().buscaPersona(persona, esquema);		

			movimientoIn.setIdtipomovimiento(PosSGlobal.TIPO_COMPRA);
			List<Movimiento> movimientos = new QueryDinamicoDao().buscaMovimientos(movimientoIn, personas, esquema);
			
			List<FacturacionDto> facturas = new ArrayList<FacturacionDto>();
			for (Movimiento movimiento : movimientos) {
				
				BigDecimal valorTotal = new BigDecimal(0);
				
				Persona cliente = new Persona();
				cliente.setIdpersona(movimiento.getIdpersona());
				cliente = new QueryDinamicoDao().buscaPersona(cliente, esquema).get(0);

				daoDetalle = DaoFactory.getDetalleMovimientoDao(DetalleMovimientoDao.class, esquema);
				daoProducto = DaoFactory.getProductoDao(ProductoDao.class, esquema);
				
				List<DetalleMovimiento> detallesList = daoDetalle.findAllById(movimiento.getIdmovimiento());
				
				List<DetalleMovimientoDto> detalles = new ArrayList<DetalleMovimientoDto>();
				for (DetalleMovimiento detalleMovimiento : detallesList) {
					
					BigDecimal cant = new BigDecimal(detalleMovimiento.getCantidad());
					BigDecimal valor = detalleMovimiento.getValor().multiply(cant);
					valorTotal = valorTotal.add(valor);

					DetalleMovimientoDto dto = new 
							DetalleMovimientoDto(
								detalleMovimiento.getIdproducto(), 
								daoProducto.findById(detalleMovimiento.getIdproducto()).getNombreproducto(), 
								detalleMovimiento.getCantidad(), 
								valor, 
								detalleMovimiento.getValor()
							);
					
					detalles.add(dto);
				}
				
				String usu = daoUsu.findById(movimiento.getIdusuario()).getNombre();
				
				FacturacionDto factura = new FacturacionDto();
				factura.setFecha(movimiento.getFecha().toString());
				factura.setIdentificacion(cliente.getIdentificacion());
				factura.setIdFactura(movimiento.getIdmovimiento());
				factura.setIdtipoidentificacion(cliente.getIdtipoidentificacion());
				factura.setNombre(cliente.getNombre());
				factura.setUsuario(usu);
				factura.setValorTotal(valorTotal);
				factura.setDetallemovimiento(detalles);
				
				facturas.add(factura);
			}

			if (null!=facturas && 0!=facturas.size())
				return new MsgResponseDto("Se encontraron "+facturas.size()+" Ingresos",true,facturas);
			else
				return new MsgResponseDto("No se encontraron ingresos!",false,null);
			
			
		} catch (Exception e) {
			log.error("Ocurrio un error al consultar el ingreso");
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al consultar el ingreso!",false,null);
		}finally{
			
			if(null!=daoUsu) daoUsu.close();
			if(null!=daoDetalle) daoDetalle.close();
			if(null!=daoProducto) daoProducto.close();
			
		}
		
	}

	public MsgResponseDto registraIngreso(Movimiento movimiento) {
		
		MovimientoDao dao = null;
		UsuarioDao daoUsu = null;
		
		try {
			
			daoUsu = DaoFactory.getUsuarioDao(UsuarioDao.class);
			Usuarios usuario = daoUsu.findByUsuario(movimiento.getUsuario());
			if(null==usuario)
				return new MsgResponseDto("El usuario "+movimiento.getUsuario()+" no existe.",false,null);
			
			movimiento.setIdusuario(usuario.getIdusuario());
			movimiento.setFecha(new Timestamp(System.currentTimeMillis()));
			movimiento.setIdtipomovimiento(PosSGlobal.TIPO_COMPRA);
			
			String esquema = new TenantController().getEsquema(usuario.getUsuario());
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario.getUsuario()+" no existe.",false,null);

			dao = DaoFactory.getMovimientoDao(MovimientoDao.class, esquema);

			int id = -1;
			id = dao.creaMovimiento(movimiento);
			
			if (id!=-1)
				return new MsgResponseDto("El Movimiento fue registrado con el id: " +id,true,id);
			else
				return new MsgResponseDto("No fue posible realizar el registro!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar el movimiento");
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al realizar el registro!",false,null);
		}finally{
			if(null!=dao) dao.close();
			if(null!=daoUsu) daoUsu.close();
		}
		
	}
	
	public MsgResponseDto consultaFactura(FacturacionDto fact) {
		
		String usuario = fact.getUsuario();
		DetalleMovimientoDao daoDetalle = null;
		ProductoDao daoProducto = null;
		UsuarioDao daoUsuario = null;

		try {
			
			String esquema = new TenantController().getEsquema(usuario);
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+fact.getUsuario()+" no existe.",false,null);
			
			Persona persona = new Persona();
			persona.setIdtipopersona(PosSGlobal.TIPO_CLIENTE);
			persona.setNombre(fact.getNombre());
			persona.setIdentificacion(fact.getIdentificacion());
			persona.setIdtipoidentificacion(fact.getIdtipoidentificacion());			
			List<Persona> personas = new QueryDinamicoDao().buscaPersona(persona, esquema);

			Date date = null; 
			if( null!=fact.getFecha() && !fact.getFecha().isEmpty() ){
				SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
				date = d.parse(fact.getFecha());
			}
			
			Movimiento movimientoBusqueda = new Movimiento();
			movimientoBusqueda.setFecha(date);
			movimientoBusqueda.setIdmovimiento(fact.getIdFactura());
			movimientoBusqueda.setIdtipomovimiento(PosSGlobal.TIPO_VENTA);
			List<Movimiento> movimientos = new QueryDinamicoDao().buscaMovimientos(movimientoBusqueda, personas, esquema);
			
			List<FacturacionDto> facturas = new ArrayList<FacturacionDto>();
			for (Movimiento movimiento : movimientos) {
				
				BigDecimal valorTotal = new BigDecimal(0);
				
				Persona cliente = new Persona();
				cliente.setIdpersona(movimiento.getIdpersona());
				cliente = new QueryDinamicoDao().buscaPersona(cliente, esquema).get(0);

				daoDetalle = DaoFactory.getDetalleMovimientoDao(DetalleMovimientoDao.class, esquema);
				daoProducto = DaoFactory.getProductoDao(ProductoDao.class, esquema);
				
				List<DetalleMovimiento> detallesList = daoDetalle.findAllById(movimiento.getIdmovimiento());
				
				List<DetalleMovimientoDto> detalles = new ArrayList<DetalleMovimientoDto>();
				for (DetalleMovimiento detalleMovimiento : detallesList) {
					
					BigDecimal cant = new BigDecimal(detalleMovimiento.getCantidad());
					BigDecimal valor = detalleMovimiento.getValor().multiply(cant);
					valorTotal = valorTotal.add(valor);

					DetalleMovimientoDto dto = new 
							DetalleMovimientoDto(
								detalleMovimiento.getIdproducto(), 
								daoProducto.findById(detalleMovimiento.getIdproducto()).getNombreproducto(), 
								detalleMovimiento.getCantidad(), 
								valor, 
								detalleMovimiento.getValor()
							);
					
					detalles.add(dto);
				}
				
				daoUsuario = DaoFactory.getUsuarioDao(UsuarioDao.class);
				String vendedor = daoUsuario.findById(movimiento.getIdusuario()).getNombre();
				
				FacturacionDto factura = new FacturacionDto();
				factura.setFecha(movimiento.getFecha().toString());
				factura.setIdentificacion(cliente.getIdentificacion());
				factura.setIdFactura(movimiento.getIdmovimiento());
				factura.setIdtipoidentificacion(cliente.getIdtipoidentificacion());
				factura.setNombre(cliente.getNombre());
				factura.setUsuario(vendedor);
				factura.setValorTotal(valorTotal);
				factura.setDetallemovimiento(detalles);
				
				facturas.add(factura);
			}

			if (null!=facturas && 0!=facturas.size())
				return new MsgResponseDto("Se encontraron "+facturas.size()+" facturas",true,facturas);
			else
				return new MsgResponseDto("No se encontraron facturas!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar las facturas.");
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar las facturas!",false,null);
		}finally{
			if(null!=daoDetalle) daoDetalle.close();
			if(null!=daoProducto) daoProducto.close();
			if(null!=daoUsuario) daoUsuario.close();
		}
		
	}

	public MsgResponseDto registraFactura(FacturacionDto fact) {
		
		MovimientoDao dao = null;
		UsuarioDao daoUsu = null;
		PersonaDao daoPersona = null;
		ProductoDao daoProducto = null;
		
		Persona cliente = new Persona();
		Integer idPersona = null;
		
		List<DetalleMovimiento> detallemovimiento = new ArrayList<>();
		
		Movimiento movimiento = new Movimiento();
		
		try {
			
			daoUsu = DaoFactory.getUsuarioDao(UsuarioDao.class);
			Usuarios usuario = daoUsu.findByUsuario(fact.getUsuario());
			if(null==usuario)
				return new MsgResponseDto("El usuario "+fact.getUsuario()+" no existe.",false,null);
			
			String esquema = new TenantController().getEsquema(usuario.getUsuario());
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario.getUsuario()+" no existe.",false,null);
			
			//Valida si hay existencia de los productos
			daoProducto = DaoFactory.getProductoDao(ProductoDao.class, esquema);
			for (DetalleMovimientoDto detalle : fact.getDetallemovimiento()) {
				
				Producto producto = daoProducto.findById(detalle.getIdproducto());
				if(null==producto){
					return new MsgResponseDto("El Producto "+detalle.getNombreproducto()+" no existe.",false,null);
				} else if( detalle.getCantidad() > producto.getExistencias() )
						return new MsgResponseDto("No hay suficientes existencias del Producto "
								+detalle.getNombreproducto()+" para realizar esta venta.",false,null);
						
			}

			//Valida los datos del cliente
			cliente.setIdentificacion(fact.getIdentificacion());
			cliente.setIdtipoidentificacion(fact.getIdtipoidentificacion());
			daoPersona = DaoFactory.getPersonaDao(PersonaDao.class, esquema);
			List<Persona> clientes = daoPersona.getPersona(cliente);
			
			//Si no existe, lo crea
			if(clientes.isEmpty()){
				cliente.setNombre(fact.getNombre());
				cliente.setIdtipopersona(PosSGlobal.TIPO_CLIENTE);
				cliente.setIdpersona(daoPersona.creaPersona(cliente));
				idPersona = cliente.getIdpersona();
			}else{
				idPersona = clientes.get(0).getIdpersona();
			}
			
			//Genera la lista de DetalleMovimientos
			for (DetalleMovimientoDto detalle : fact.getDetallemovimiento()) {
				
				DetalleMovimiento detalleMov = new DetalleMovimiento();
				detalleMov.setCantidad(detalle.getCantidad());
				detalleMov.setIdproducto(detalle.getIdproducto());
				detalleMov.setNombreproducto(detalle.getNombreproducto());
				detalleMov.setObservacion("Venta de Producto");
				detalleMov.setValor(detalle.getValorunitario());
				
				detallemovimiento.add(detalleMov);
			}
			
			movimiento.setIdusuario(usuario.getIdusuario());
			movimiento.setFecha(new Timestamp(System.currentTimeMillis()));
			movimiento.setIdtipomovimiento(PosSGlobal.TIPO_VENTA);
			movimiento.setIdpersona(idPersona);
			movimiento.setDetallemovimiento(detallemovimiento);

			dao = DaoFactory.getMovimientoDao(MovimientoDao.class, esquema);

			int id = -1;
			id = dao.creaMovimiento(movimiento);
			
			if (id!=-1)
				return new MsgResponseDto("La factura No. " +id+" fue creada exitosamente.",true,id);
			else
				return new MsgResponseDto("No fue posible registrar la factura",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al registrar la factura");
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al registrar la factura!",false,null);
		}finally{
			
			if(null!=dao) dao.close();
			if(null!=daoUsu) daoUsu.close();
			if(null!=daoPersona) daoPersona.close();
			if(null!=daoProducto) daoProducto.close();
			
		}

	}

	
}
