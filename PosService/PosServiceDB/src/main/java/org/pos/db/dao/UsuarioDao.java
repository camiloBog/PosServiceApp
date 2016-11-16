package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Usuarios;
import org.pos.db.mapper.UsuarioMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UsuarioMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public abstract class UsuarioDao {
	
	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".USUARIOS (idusuario, usuario, nombre, apellidos, contrasena, idperfil, idtenant) "
			+ "values (:idusuario, :usuario, :nombre, :apellidos, :contrasena, :idperfil, :idtenant)")
	protected abstract void insert(@BindBean Usuarios usuarios);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIOS where idusuario = :id")
	public abstract Usuarios findById(@Bind("id") int id);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIOS where usuario = :usuario")
	public abstract Usuarios findByUsuario(@Bind("usuario") String usuario);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIOS where usuario = :usuario and contrasena = :contrasena")
	public abstract Usuarios validate(@Bind("usuario") String usuario, @Bind("contrasena") String contrasena);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIOS")
	public abstract List<Usuarios> findAll();
	
	@SqlUpdate("update "+PosSGlobal.ESQUEMA+".USUARIOS set apellidos = :u.apellidos, "
			+ "contrasena = :u.contrasena, nombre = :u.nombre, "
			+ "idperfil = :u.idperfil, idtenant = :u.idtenant "
			+ "where usuario = :u.usuario and idusuario = :u.idusuario")
	public abstract void update(@BindBean("u") Usuarios usuario);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".USUARIOS where idusuario = :idusuario")
	public abstract void deleteById(@Bind("idusuario") int idusuario);
	
	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".usuario_seq')")
	public abstract int getSecuence();
	
	public abstract void close();
	
	@Transaction
	public int creaUsuario(Usuarios usuario) {
		int id = getSecuence();
		usuario.setIdusuario(id);
		insert(usuario);
		return id;
	}
	
}