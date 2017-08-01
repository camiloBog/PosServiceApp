package org.pos.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.pos.db.bind.DbiProvider;
import org.pos.db.entidades.Movimiento;
import org.pos.db.entidades.Persona;
import org.pos.db.entidades.Producto;
import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.Usuarios;
import org.pos.db.mapper.MovimientoMapper;
import org.pos.db.mapper.PersonaMapper;
import org.pos.db.mapper.ProductoMapper;
import org.pos.db.mapper.TenantMapper;
import org.pos.db.mapper.UsuarioMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

public class QueryDinamicoDao {
	
	private Logger log = LogManager.getLogger(QueryDinamicoDao.class);
	
	private Handle handle;
	
	public QueryDinamicoDao() {
		DBI dbi = DbiProvider.getSimpleDBI();
		this.handle = dbi.open();
	}
	
	private void closeHandle(){
		try {
			if (null != handle)
				handle.close();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	public List<Movimiento> buscaFacturas(Movimiento fact, String esquema) {

		try {

			String sql = "SELECT * FROM " + esquema + ".MOVIMIENTO WHERE ";

			if (null != fact.getIdmovimiento())
				sql += "IDMOVIMIENTO = :idmovimiento AND ";
			if (null != fact.getIdtipomovimiento())
				sql += "IDTIPOMOVIMIENTO = :idtipomovimiento AND ";
			if (null != fact.getIdpersona())
				sql += "IDPERSONA = :idpersona AND ";	
			sql += "1=1 ORDER BY IDMOVIMIENTO";

			Query<Map<String, Object>> query = handle.createQuery(sql);
			if (null != fact.getIdmovimiento())
				query.bind("idmovimiento", fact.getIdmovimiento());
			if (null != fact.getIdtipomovimiento())
				query.bind("idtipomovimiento", fact.getIdtipomovimiento());
			if (null != fact.getIdpersona())
				query.bind("idpersona", fact.getIdpersona());

			return query.map(new MovimientoMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar los movimientos!");
			log.error(e.getMessage());
			return null;
		} finally {
			closeHandle();
		}

	}

	public List<Producto> buscaProducto(Producto producto, String esquema) {

		try {

			String sql = "SELECT * FROM " + esquema + ".PRODUCTO WHERE ";

			if (null != producto.getIdproducto())
				sql += "IDPRODUCTO = :idproducto AND ";
			if (null != producto.getIdtipomedida())
				sql += "IDTIPOMEDIDA = :idtipomedida AND ";
			if (null != producto.getNombreproducto() && !"".equals(producto.getNombreproducto()))
				sql += "LOWER(NOMBREPRODUCTO) LIKE LOWER('%'||:nombreproducto||'%') AND ";
			if (null != producto.getDescripcion() && !"".equals(producto.getDescripcion()))
				sql += "LOWER(DESCRIPCION) LIKE LOWER('%'||:descripcion||'%') AND ";
			sql += "1=1 ORDER BY IDPRODUCTO";

			Query<Map<String, Object>> query = handle.createQuery(sql);
			if (null != producto.getIdproducto())
				query.bind("idproducto", producto.getIdproducto());
			if (null != producto.getIdtipomedida())
				query.bind("idtipomedida", producto.getIdtipomedida());
			if (null != producto.getNombreproducto() && !"".equals(producto.getNombreproducto()))
				query.bind("nombreproducto", producto.getNombreproducto());
			if (null != producto.getDescripcion() && !"".equals(producto.getDescripcion()))
				query.bind("descripcion", producto.getDescripcion());

			return query.map(new ProductoMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto!");
			log.error(e.getMessage());
			return null;
		} finally {
			closeHandle();
		}

	}
	
	public List<Persona> buscaPersona(Persona persona, String esquema) {

		try {
			
			String sql = "SELECT * FROM " + esquema + ".PERSONA WHERE ";

			if (null != persona.getIdpersona())
				sql += "IDPERSONA = :idpersona AND ";
			if (null != persona.getIdtipopersona())
				sql += "IDTIPOPERSONA = :idtipopersona AND ";
			if (null != persona.getIdentificacion())
				sql += "IDENTIFICACION = :identificacion AND ";
			if (null != persona.getNombre() && !"".equals(persona.getNombre()))
				sql += "LOWER(NOMBRE) LIKE LOWER('%'||:nombre||'%') AND ";
			if (null != persona.getDireccion() && !"".equals(persona.getDireccion()))
				sql += "LOWER(DIRECCION) LIKE LOWER('%'||:direccion||'%') AND ";
			if (null != persona.getTelefono() && !"".equals(persona.getTelefono()))
				sql += "LOWER(TELEFONO) LIKE LOWER('%'||:telefono||'%') AND ";
			if (null != persona.getCorreocontacto() && !"".equals(persona.getCorreocontacto()))
				sql += "LOWER(CORREOCONTACTO) LIKE LOWER('%'||:correocontacto||'%') AND ";
			if (null != persona.getContacto() && !"".equals(persona.getContacto()))
				sql += "LOWER(CONTACTO) LIKE LOWER('%'||:contacto||'%') AND ";
			sql += "1=1 ORDER BY IDPERSONA";

			Query<Map<String, Object>> query = handle.createQuery(sql);
			
			if (null != persona.getIdpersona())
				query.bind("idpersona", persona.getIdpersona());
			if (null != persona.getIdtipopersona())
				query.bind("idtipopersona", persona.getIdtipopersona());
			if (null != persona.getIdentificacion())
				query.bind("identificacion", persona.getIdentificacion());
			if (null != persona.getNombre() && !"".equals(persona.getNombre()))
				query.bind("nombre", persona.getNombre());
			if (null != persona.getDireccion() && !"".equals(persona.getDireccion()))
				query.bind("direccion", persona.getDireccion());
			if (null != persona.getTelefono() && !"".equals(persona.getTelefono()))
				query.bind("telefono", persona.getTelefono());
			if (null != persona.getCorreocontacto() && !"".equals(persona.getCorreocontacto()))
				query.bind("correocontacto", persona.getCorreocontacto());
			if (null != persona.getContacto() && !"".equals(persona.getContacto()))
				query.bind("contacto", persona.getContacto());

			return query.map(new PersonaMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el registro!");
			log.error(e.getMessage());
			return null;
		} finally {
			closeHandle();
		}

	}

	public List<Usuarios> buscaUsuario(Usuarios usuario) {

		try {
			
			String sql = "SELECT * FROM " + PosSGlobal.ESQUEMA_BASE + ".USUARIOS WHERE ";
			
			if (null != usuario.getIdusuario())
				sql += "IDUSUARIO = :idusuario AND ";
			if (null != usuario.getIdperfil())
				sql += "IDPERFIL = :idperfil AND ";
			if (null != usuario.getIdtenant())
				sql += "IDTENANT = :idtenant AND ";
			if (null != usuario.getUsuario() && !"".equals(usuario.getUsuario()))
				sql += "LOWER(USUARIO) LIKE LOWER('%'||:usuario||'%') AND ";
			if (null != usuario.getNombre() && !"".equals(usuario.getNombre()))
				sql += "LOWER(NOMBRE) LIKE LOWER('%'||:nombre||'%') AND ";
			if (null != usuario.getApellidos() && !"".equals(usuario.getApellidos()))
				sql += "LOWER(APELLIDOS) LIKE LOWER('%'||:apellidos||'%') AND ";
			sql += "1=1 ORDER BY USUARIO";

			Query<Map<String, Object>> query = handle.createQuery(sql);
			
			if (null != usuario.getIdusuario())
				query.bind("idusuario", usuario.getIdusuario());
			if (null != usuario.getIdperfil())
				query.bind("idperfil", usuario.getIdperfil());
			if (null != usuario.getIdtenant())
				query.bind("idtenant", usuario.getIdtenant());
			if (null != usuario.getUsuario() && !"".equals(usuario.getUsuario()))
				query.bind("usuario", usuario.getUsuario());
			if (null != usuario.getNombre() && !"".equals(usuario.getNombre()))
				query.bind("nombre", usuario.getNombre());
			if (null != usuario.getApellidos() && !"".equals(usuario.getApellidos()))
				query.bind("apellidos", usuario.getApellidos());

			return query.map(new UsuarioMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el usuario!");
			log.error(e.getMessage());
			return null;
		} finally {
			closeHandle();
		}
		
	}
	
	public List<Tenant> buscaTenant(Tenant tenant) {

		try {

			String sql = "SELECT * FROM " + PosSGlobal.ESQUEMA_BASE + ".TENANT WHERE ";
			
			if (null != tenant.getIdtenant())
				sql += "IDTENANT = :idtenant AND ";
			if(null != tenant.getTipoidentificacion())
				sql += "TIPOIDENTIFICACION = :tipoidentificacion AND ";
			if (null != tenant.getIdentificacion() && !"".equals(tenant.getIdentificacion()))
				sql += "LOWER(IDENTIFICACION) LIKE LOWER('%'||:identificacion||'%') AND ";
			if (null != tenant.getNombre() && !"".equals(tenant.getNombre()))
				sql += "LOWER(NOMBRE) LIKE LOWER('%'||:nombre||'%') AND ";
			if (null != tenant.getDireccion() && !"".equals(tenant.getDireccion()))
				sql += "LOWER(DIRECCION) LIKE LOWER('%'||:direccion||'%') AND ";
			if (null != tenant.getTelefono() && !"".equals(tenant.getTelefono()))
				sql += "LOWER(TELEFONO) LIKE LOWER('%'||:telefono||'%') AND ";
			sql += "1=1 ORDER BY IDTENANT";

			Query<Map<String, Object>> query = handle.createQuery(sql);
			
			if (null != tenant.getIdtenant())
				query.bind("idtenant", tenant.getIdtenant());
			if(null != tenant.getTipoidentificacion())
				query.bind("tipoidentificacion", tenant.getTipoidentificacion());
			if (null != tenant.getIdentificacion() && !"".equals(tenant.getIdentificacion()))
				query.bind("identificacion", tenant.getIdentificacion());
			if (null != tenant.getNombre() && !"".equals(tenant.getNombre()))
				query.bind("nombre", tenant.getNombre());
			if (null != tenant.getDireccion() && !"".equals(tenant.getDireccion()))
				query.bind("direccion", tenant.getDireccion());
			if (null != tenant.getTelefono() && !"".equals(tenant.getTelefono()))
				query.bind("telefono", tenant.getTelefono());

			return query.map(new TenantMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el tenant!");
			log.error(e.getMessage());
			return null;
		} finally {
			closeHandle();
		}
		
	}

}
