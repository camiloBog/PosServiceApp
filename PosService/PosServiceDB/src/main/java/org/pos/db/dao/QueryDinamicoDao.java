package org.pos.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.pos.db.bind.DbiProvider;
import org.pos.db.entidades.Persona;
import org.pos.db.entidades.Producto;
import org.pos.db.entidades.Usuarios;
import org.pos.db.mapper.PersonaMapper;
import org.pos.db.mapper.ProductoMapper;
import org.pos.db.mapper.UsuarioMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

public class QueryDinamicoDao {
	
	private Logger log = LogManager.getLogger(QueryDinamicoDao.class);

	public List<Producto> buscaProducto(Producto producto, String esquema) {
		
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
			if (null != producto.getIdproducto())
				query.bind("idproducto", producto.getIdproducto());
			else if (null != producto.getIdtipomedida())
				query.bind("idtipomedida", producto.getIdtipomedida());
			else if (null != producto.getNombreproducto() && !"".equals(producto.getNombreproducto()))
				query.bind("nombreproducto", producto.getNombreproducto());
			else if (null != producto.getDescripcion() && !"".equals(producto.getDescripcion()))
				query.bind("descripcion", producto.getDescripcion());

			return query.map(new ProductoMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el producto!");
			log.error(e.getMessage());
			return null;
		} finally {
			if (null != handle)
				handle.close();
		}

	}
	
	public List<Persona> buscaPersona(Persona persona, String esquema) {
		
		Handle handle = null;

		try {
			
			String sql = "SELECT * FROM " + esquema + ".PERSONA WHERE ";

			if (null != persona.getIdpersona())
				sql += "IDPERSONA = :idpersona AND ";
			else if (null != persona.getIdtipopersona())
				sql += "IDTIPOPERSONA = :idtipopersona AND ";
			else if (null != persona.getIdentificacion())
				sql += "IDENTIFICACION = :identificacion AND ";
			else if (null != persona.getNombre() && !"".equals(persona.getNombre()))
				sql += "LOWER(NOMBRE) LIKE LOWER('%'||:nombre||'%') AND ";
			else if (null != persona.getDireccion() && !"".equals(persona.getDireccion()))
				sql += "LOWER(DIRECCION) LIKE LOWER('%'||:direccion||'%') AND ";
			else if (null != persona.getTelefono() && !"".equals(persona.getTelefono()))
				sql += "LOWER(TELEFONO) LIKE LOWER('%'||:telefono||'%') AND ";
			else if (null != persona.getCorreocontacto() && !"".equals(persona.getCorreocontacto()))
				sql += "LOWER(CORREOCONTACTO) LIKE LOWER('%'||:correocontacto||'%') AND ";
			else if (null != persona.getContacto() && !"".equals(persona.getContacto()))
				sql += "LOWER(CONTACTO) LIKE LOWER('%'||:contacto||'%') AND ";
			sql += "1=1";

			DBI dbi = DbiProvider.getSimpleDBI();
			handle = dbi.open();

			Query<Map<String, Object>> query = handle.createQuery(sql);
			
			if (null != persona.getIdpersona())
				query.bind("idpersona", persona.getIdpersona());
			else if (null != persona.getIdtipopersona())
				query.bind("idtipopersona", persona.getIdtipopersona());
			else if (null != persona.getIdentificacion())
				query.bind("identificacion", persona.getIdentificacion());
			else if (null != persona.getNombre() && !"".equals(persona.getNombre()))
				query.bind("nombre", persona.getNombre());
			else if (null != persona.getDireccion() && !"".equals(persona.getDireccion()))
				query.bind("direccion", persona.getDireccion());
			else if (null != persona.getTelefono() && !"".equals(persona.getTelefono()))
				query.bind("telefono", persona.getTelefono());
			else if (null != persona.getCorreocontacto() && !"".equals(persona.getCorreocontacto()))
				query.bind("correocontacto", persona.getCorreocontacto());
			else if (null != persona.getContacto() && !"".equals(persona.getContacto()))
				query.bind("contacto", persona.getContacto());

			return query.map(new PersonaMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el registro!");
			log.error(e.getMessage());
			return null;
		} finally {
			if (null != handle)
				handle.close();
		}

	}

	public List<Usuarios> buscaUsuario(Usuarios usuario) {
		
		Handle handle = null;

		try {
			
			String sql = "SELECT * FROM " + PosSGlobal.ESQUEMA_BASE + ".USUARIOS WHERE ";
			
			if (null != usuario.getIdusuario())
				sql += "IDUSUARIO = :idusuario AND ";
			else if (null != usuario.getIdperfil())
				sql += "IDPERFIL = :idperfil AND ";
			else if (null != usuario.getIdtenant())
				sql += "IDTENANT = :idtenant AND ";
			else if (null != usuario.getUsuario() && !"".equals(usuario.getUsuario()))
				sql += "LOWER(USUARIO) LIKE LOWER('%'||:usuario||'%') AND ";
			else if (null != usuario.getNombre() && !"".equals(usuario.getNombre()))
				sql += "LOWER(NOMBRE) LIKE LOWER('%'||:nombre||'%') AND ";
			else if (null != usuario.getApellidos() && !"".equals(usuario.getApellidos()))
				sql += "LOWER(APELLIDOS) LIKE LOWER('%'||:apellidos||'%') AND ";
			sql += "1=1";

			DBI dbi = DbiProvider.getSimpleDBI();
			handle = dbi.open();

			Query<Map<String, Object>> query = handle.createQuery(sql);
			
			if (null != usuario.getIdusuario())
				query.bind("idusuario", usuario.getIdusuario());
			else if (null != usuario.getIdperfil())
				query.bind("idperfil", usuario.getIdperfil());
			else if (null != usuario.getIdtenant())
				query.bind("idtenant", usuario.getIdtenant());
			else if (null != usuario.getUsuario() && !"".equals(usuario.getUsuario()))
				query.bind("usuario", usuario.getUsuario());
			else if (null != usuario.getNombre() && !"".equals(usuario.getNombre()))
				query.bind("nombre", usuario.getNombre());
			else if (null != usuario.getApellidos() && !"".equals(usuario.getApellidos()))
				query.bind("apellidos", usuario.getApellidos());

			return query.map(new UsuarioMapper()).list();

		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el usuario!");
			log.error(e.getMessage());
			return null;
		} finally {
			if (null != handle)
				handle.close();
		}
		
	}

}
