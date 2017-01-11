package org.pos.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.core.dto.LoginResponseDto;
import org.pos.core.dto.MenuDto;
import org.pos.core.dto.MsgResponseDto;
import org.pos.db.bind.DaoFactory;
import org.pos.db.dao.PerfilesDao;
import org.pos.db.dao.QueryDinamicoDao;
import org.pos.db.dao.TipoIdentificacionDao;
import org.pos.db.dao.TipoMedidaDao;
import org.pos.db.dao.TipoPersonasDao;
import org.pos.db.dao.UsuarioDao;
import org.pos.db.entidades.Perfiles;
import org.pos.db.entidades.Tenant;
import org.pos.db.entidades.TipoIdentificacion;
import org.pos.db.entidades.TipoMedida;
import org.pos.db.entidades.TipoPersonas;
import org.pos.db.entidades.Usuarios;

public class UsuarioController {
	
	private Logger log = LogManager.getLogger(UsuarioController.class);
	
	public Usuarios findByUsuario(Usuarios usuarioIn) {
		
		UsuarioDao dao = null;
		
		try {
			
			dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			return dao.findByUsuario(usuarioIn.getUsuario());
			
		} catch (NumberFormatException e) {
			log.error("Ocurrio un error al realizar la consulta del usuario. " + e.getMessage() );
			return null;
		}finally {
			if(dao!=null)
				dao.close();
		}
		
	}

	public MsgResponseDto buscaUsuarioSeguridad(Usuarios usuarioIn) {
		
		Usuarios usuario = findByUsuario(usuarioIn);
		
		if (usuario!=null){
			//Se ocultan datos por seguridad.
			usuario.setContrasena("*******");
			usuario.setIdusuario(null);
			
			return new MsgResponseDto("Se encontro el usuario "+usuario.getUsuario(), true, usuario);
		} else {
			return new MsgResponseDto("No fue posible encontrar el usuario.", false, null);
		}

	}

	public MsgResponseDto actualizarUSuario(Usuarios usuariosIn) {
		
		try {
			
			Usuarios usu = findByUsuario(usuariosIn);
			if(usu==null)
				return new MsgResponseDto("No existe el usuario: "+usuariosIn.getUsuario(), false, null);
			
			if(!"".equals(usuariosIn.getNombre()) && null!=usuariosIn.getNombre()){
				Perfiles perfil = new TiposController().getPerfilById(usuariosIn.getIdperfil());
				if(perfil==null)
					return new MsgResponseDto("No existe el perfil: "+usuariosIn.getIdperfil(), false, null);
				else
					usu.setIdperfil(perfil.getIdperfil());
			}
			
			if(!"".equals(usuariosIn.getIdtenant()) && null!=usuariosIn.getIdtenant()){
				Tenant tenant = new TenantController().findByIdTenant(usuariosIn.getIdtenant());
				if(tenant==null)
					return new MsgResponseDto("No existe el Tenant: "+usuariosIn.getIdtenant(), false, null);
				else
					usu.setIdtenant(tenant.getIdtenant());
			}
			
			if(!"".equals(usuariosIn.getNombre()) && null!=usuariosIn.getNombre())
				usu.setNombre(usuariosIn.getNombre());
			
			if(!"".equals(usuariosIn.getApellidos()) && null!=usuariosIn.getApellidos())
				usu.setApellidos(usuariosIn.getApellidos());

			if(!"".equals(usuariosIn.getContrasena()) && null!=usuariosIn.getContrasena())
				usu.setContrasena(usuariosIn.getContrasena());
			
			UsuarioDao dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			dao.update(usu);

			return new MsgResponseDto("El usuario ha sido actualizado exitosamente", true, null);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un problema al actualizar el usuario.", false, null);
		}

	}
	
	
	public MsgResponseDto crearUSuario(Usuarios usuarios) {
		
		Perfiles perfil = new TiposController().getPerfilById(usuarios.getIdperfil());
		if(perfil==null)
			return new MsgResponseDto("No existe el perfil: "+usuarios.getIdperfil(), false, null);
		
		Tenant tenant = new TenantController().findByIdTenant(usuarios.getIdtenant());
		if(tenant==null)
			return new MsgResponseDto("No existe el Tenant: "+usuarios.getIdtenant(), false, null);
		
		UsuarioDao daoU = null;
		
		try {
			
			daoU = DaoFactory.getUsuarioDao(UsuarioDao.class);
			
			//Se valida si el nombre de usuario ya existe.
			if(daoU.findByUsuario(usuarios.getUsuario()) != null)
				return new MsgResponseDto("El usuario: '"+usuarios.getUsuario()+"' ya existe, por favor intentalo de nuevo.",
						false, null);

			int id = -1;
			id = daoU.creaUsuario(usuarios);
			
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
	
	public LoginResponseDto validarUsuario(Usuarios usuarios) {
		
		UsuarioDao dao = null;
		Usuarios usu = null;
		
		//Valida si coinciden el usuario y la contrasena
		try {
			dao = DaoFactory.getUsuarioDao(UsuarioDao.class);
			usu = dao.validate(usuarios.getUsuario(), usuarios.getContrasena());
			
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
			log.error("Ocurrio un error al cargar los tipos de medidas.");
			log.error(e.getMessage());
		}finally {
			if(null!=daoM)
				daoM.close();
		}
		
		TipoPersonasDao daoPersonas = null;
		List<TipoPersonas> tipoPersonas = null;
		
		//Obtiene los tipos de Personas, para enviarlos al front
		try {
			daoPersonas = DaoFactory.getTipoPersonasDao(TipoPersonasDao.class);
			tipoPersonas = daoPersonas.findAll();
		} catch (Exception e) {
			log.error("Ocurrio un error al cargar los tipos de personas.");
			log.error(e.getMessage());
		}
		
		
		
		Tenant t = new Tenant();
		try {
			t = new TenantController().findByIdTenant(usu.getIdtenant());
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
			login.setTiposPersonas(tipoPersonas);
			
			return login;
			
		}
		
		return null; 
		
	}

	public MsgResponseDto BuscarUsuario(Usuarios usuario) {
		
		try {
			
			String esquema = new TenantController().getEsquema(usuario.getUsuario());
			if("".equals(esquema) || null==esquema)
				return new MsgResponseDto("El usuario "+usuario.getUsuario()+" no existe.",false,null);
			
			List<Usuarios> usuarios = new QueryDinamicoDao().buscaUsuario(usuario, esquema);
			
			if (null!=usuarios && 0!=usuarios.size())
				return new MsgResponseDto("Se encontraron "+usuarios.size()+" usuarios",true,usuarios);
			else
				return new MsgResponseDto("No se encontraron usuarios!",false,null);
			
		} catch (Exception e) {
			log.error("Ocurrio un error al buscar el usuario " + usuario.getUsuario());
			log.error(e.getMessage());
			return new MsgResponseDto("Ocurrio un error al buscar el usuario!",false,null);
		}
		
	}

}
