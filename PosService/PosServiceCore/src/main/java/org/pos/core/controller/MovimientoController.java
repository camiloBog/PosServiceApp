package org.pos.core.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.pos.core.dto.DetalleMovimientoDto;
import org.pos.core.dto.FacturacionDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.MovimientoDao;
import org.pos.db.dao.PersonaDao;
import org.pos.db.dao.QueryDinamicoDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.DetalleMovimiento;
import org.pos.db.entidades.Movimiento;
import org.pos.db.entidades.Persona;
import org.pos.db.entidades.Usuarios;


public class MovimientoController {
	
	private Logger log = LogManager.getLogger(MovimientoController.class);

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
			if(null!=dao)
				dao.close();
		}
		
	}
	
	public MsgResponseDto consultaFactura(FacturacionDto fact) {
		
		String usuario = fact.getUsuario();

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

			Movimiento movimientoBusqueda = new Movimiento();
			movimientoBusqueda.setFecha(fact.getFecha());
			movimientoBusqueda.setIdmovimiento(fact.getIdFactura());
			movimientoBusqueda.setIdtipomovimiento(PosSGlobal.TIPO_VENTA);
			List<Movimiento> movimientos = new QueryDinamicoDao().buscaFacturas(movimientoBusqueda, personas, esquema);
			
			
			List<FacturacionDto> facturas = new ArrayList<FacturacionDto>();
			for (Movimiento movimiento : movimientos) {
				
				Persona cliente = new Persona();
				cliente.setIdpersona(movimiento.getIdpersona());
				cliente = new QueryDinamicoDao().buscaPersona(cliente, esquema).get(0);
				
				**** POR IMPLEMENTAR **** 
				List<DetalleMovimientoDto> detalles = 
					new QueryDinamicoDao().buscaDetallesMovimiento(movimiento, esquema);
				
				FacturacionDto factura = new FacturacionDto();
				factura.setFecha(movimiento.getFecha());
				factura.setIdentificacion(cliente.getIdentificacion());
				factura.setIdFactura(movimiento.getIdmovimiento());
				factura.setIdtipoidentificacion(cliente.getIdtipoidentificacion());
				factura.setNombre(cliente.getNombre());
				factura.setUsuario(movimiento.getIdusuario().toString());
				factura.setDetallemovimiento(detalles);
				
				facturas.add(factura);
			}

			if (null!=facturas && 0!=facturas.size())
				return new MsgResponseDto("Se encontraron "+movimientos.size()+" facturas",true,facturas);
			else
				return new MsgResponseDto("No se encontraron facturas!",false,null);
			
			
//			if (null!=movimientos && 0!=movimientos.size())
//				return new MsgResponseDto("Se encontraron "+movimientos.size()+" movimientos",true,movimientos);
//			else
//				return new MsgResponseDto("No se encontraron movimientos!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar las facturas. " + usuario);
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar las facturas!",false,null);
		}
		
	}

	public MsgResponseDto registraFactura(FacturacionDto fact) {
		
		MovimientoDao dao = null;
		UsuarioDao daoUsu = null;
		
		PersonaDao daoPersona = null;
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
			if(null!=dao)
				dao.close();
		}

	}

	
}
