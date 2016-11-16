package org.pos.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MenuDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.PerfilesDao;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.dao.TipoMedidaDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.Perfiles;
import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.TipoIdentificacion;
import org.pos.db.entidades.TipoMedida;
import org.pos.db.entidades.Usuarios;

public class UsuarioController {
	
	private Logger log = LogManager.getLogger(UsuarioController.class);
	
	public Usuarios findByUsuario(String usuario) {
		
		UsuarioDao dao = null;
		
		try {
			
			dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			return dao.findByUsuario(usuario);
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del usuario. " + e.getMessage() );
			return null;
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}

	public MsgResponseDto BuscaUsuario(String usu) {
		
		Usuarios usuario = findByUsuario(usu);
		
		if (usuario!=null){
			
			usuario.setContrasena("*******");
			usuario.setIdusuario(null);
			
			return new MsgResponseDto("Se encontro el usuario "+usu, true, usuario);
		} else {
			return new MsgResponseDto("No fue posible crear el usuario.", false, null);
		}

	}

	public MsgResponseDto actualizarUSuario(String usuario, String nombre, String apellidos, String contrasena,
			String idperfil, String idtenant) {
		
		try {
			
			Usuarios usu = findByUsuario(usuario);
			if(usu==null)
				return new MsgResponseDto("No existe el usuario: "+usuario, false, null);
			
			if(!"".equals(nombre) && null!=nombre){
				Perfiles perfil = new TiposController().getPerfilById(idperfil);
				if(perfil==null)
					return new MsgResponseDto("No existe el perfil: "+idperfil, false, null);
				else
					usu.setIdperfil(perfil.getIdperfil());
			}
			
			if(!"".equals(idtenant) && null!=idtenant){
				Tenant tenant = new TenantController().findByIdTenant(idtenant);
				if(tenant==null)
					return new MsgResponseDto("No existe el Tenant: "+idtenant, false, null);
				else
					usu.setIdtenant(tenant.getIdtenant());
			}
			
			if(!"".equals(nombre) && null!=nombre)
				usu.setNombre(nombre);
			
			if(!"".equals(apellidos) && null!=apellidos)
				usu.setApellidos(apellidos);

			if(!"".equals(contrasena) && null!=contrasena)
				usu.setContrasena(contrasena);
			
			UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			dao.update(usu);

			return new MsgResponseDto("El usuario ha sido actualizado exitosamente", true, null);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un problema al actualizar el usuario.", false, null);
		}

	}
	
	public MsgResponseDto crearUSuario(String usuario, String nombre, 
			String apellidos, String contrasena, String idperfil, String idtenant) {
		
		Perfiles perfil = new TiposController().getPerfilById(idperfil);
		if(perfil==null)
			return new MsgResponseDto("No existe el perfil: "+idperfil, false, null);
		
		Tenant tenant = new TenantController().findByIdTenant(idtenant);
		if(tenant==null)
			return new MsgResponseDto("No existe el Tenant: "+idtenant, false, null);
		
		UsuarioDao daoU = null;
		
		Usuarios usu = new Usuarios();
		usu.setApellidos(apellidos);
		usu.setContrasena(contrasena);
		usu.setIdperfil(perfil.getIdperfil());
		usu.setIdtenant(tenant.getIdtenant());
		usu.setNombre(nombre);
		usu.setUsuario(usuario);
		
		try {
			
			daoU = DaoFactory.getUsuarioDao(UsuarioDao.class);
			
			//Se valida si el nombre de usuario ya existe.
			if(daoU.findByUsuario(usuario) != null)
				return new MsgResponseDto("El usuario: '"+usuario+"' ya existe, por favor intentalo de nuevo.",
						false, null);

			int id = -1;
			id = daoU.creaUsuario(usu);
			
			if (id!=-1)
				return new MsgResponseDto("El usuario ha sido creado exitosamente con el ID: "+id, true, null);
			else
				return new MsgResponseDto("No fue posible crear el usuario.", false, null);

		} catch (Exception e) {
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un problema al crear el usuario.", false, null);
		}finally {
			if(null!=daoU)
				daoU.close();
		}

	}

	public LoginResponseDto validarUsuario(String usuario, String contrasena) {
		
		UsuarioDao dao = null;
		Usuarios usu = null;
		
		//Valida si coinciden el usuario y la contrasena
		try {
			dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			usu = dao.validate(usuario, contrasena);
			
			if(null==usu){
				log.error("Validacion de usuario incorrecta.");
				return null;
			}
				
			
		} catch (Exception e) {
			log.error("Ocurrio un error al realizar la validacion de usuario.");
			log.error(e.getMessage());
			return null;
		}finally {
			if(null!=dao)
				dao.close();
		}
		
		TipoIdentificacionDao dao2 = null;
		List<TipoIdentificacion> ti = null;
		
		//Obtiene los tipos de identificacion, para enviarlos al front
		try {
			dao2 = DaoFactory.getTipoIdentificacionDao(TipoIdentificacionDao.class);
			ti = dao2.findAll();
		} catch (Exception e) {
			log.error("Ocurrio un error al obtener los tipos de identificacion.");
			log.error(e.getMessage());
		}finally {
			if(null!=dao2)
				dao2.close();
		}
		
		
		PerfilesDao daoP = null;
		List<Perfiles> perfiles = null;
		
		//Obtiene los tipos de Perfiles, para enviarlos al front
		try {
			daoP = DaoFactory.getPerfilesDao(PerfilesDao.class);
			perfiles = daoP.findAll();
		} catch (Exception e) {
			log.error("Ocurrio un error al obtener los tipos de perfiles.");
			log.error(e.getMessage());
		}finally {
			if(null!=daoP)
				daoP.close();
		}
		
		TipoMedidaDao daoM = null;
		List<TipoMedida> medidas = null;
		
		//Obtiene los tipos de Medidas, para enviarlos al front
		try {
			daoM = DaoFactory.getTipoMedidaDao(TipoMedidaDao.class);
			medidas = daoM.findAll();
		} catch (Exception e) {
			log.error("Ocurrio un error al tipos de medidas.");
			log.error(e.getMessage());
		}finally {
			if(null!=daoM)
				daoM.close();
		}
		
		Tenant t = new Tenant();
		try {
			t = new TenantController().findByIdTenant(usu.getIdtenant().toString());
		} catch (Exception e) {
			log.error("Ocurrio un error obtener el Tenant del usuario.");
			log.error(e.getMessage());
		}
		
		MenuDto menu = null;
		if(usu.getIdperfil()==1)
			menu = new MenuController().getAdministrador();
		else if(usu.getIdperfil()==2)
			menu = new MenuController().getUsuario();
		else
			menu = new MenuController().getFullAdministrador();

		if (usu!=null) {

			LoginResponseDto login = new LoginResponseDto();
			login.setMensaje("");
			login.setNombre(usu.getNombre());
			login.setTenant(usu.getIdtenant());
			login.setTenantName(t.getNombre());
			login.setUsuario(usu.getUsuario());
			login.setValidacion(true);
			login.setMenu(menu);
			login.setTiposIdentificacion(ti);
			login.setTiposPerfiles(perfiles);
			login.setTipoMedida(medidas);
			
			return login;
			
		}
		
		return null; 
		
	}

}
