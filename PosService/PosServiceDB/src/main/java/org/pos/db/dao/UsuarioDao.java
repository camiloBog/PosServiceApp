package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Usuario;
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
	
	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".USUARIO (idusuario, apellidos, contrasena, nombre, usuario, idperfil, idtenant) "
			+ "values (:idusuario, :apellidos, :contrasena, :nombre, :usuario, :idperfil, :idtenant)")
	protected abstract void insert(@BindBean Usuario usuario);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO where idusuario = :id")
	public abstract Usuario findById(@Bind("id") int id);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO where usuario = :usuario")
	public abstract Usuario findByUsuario(@Bind("usuario") String usuario);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO where usuario = :usuario and contrasena = :contrasena")
	public abstract Usuario validate(@Bind("usuario") String usuario, @Bind("contrasena") String contrasena);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO")
	public abstract List<Usuario> findAll();
	
	@SqlUpdate("update "+PosSGlobal.ESQUEMA+".USUARIO set apellidos = :u.apellidos, "
			+ "contrasena = :u.contrasena, nombre = :u.nombre, "
			+ "idperfil = :u.idperfil, idtenant = :u.idtenant "
			+ "where usuario = :u.usuario and idusuario = :u.idusuario")
	public abstract void update(@BindBean("u") Usuario usuario);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".USUARIO where idusuario = :idusuario")
	public abstract void deleteById(@Bind("idusuario") int idusuario);
	
	@SqlQuery("select nextval('"+PosSGlobal.ESQUEMA+".usuario_seq')")
	public abstract int getSecuence();
	
	public abstract void close();
	
	@Transaction
	public int creaUsuario(Usuario usuario) {
		int id = getSecuence();
		usuario.setIdusuario(id);
		insert(usuario);
		return id;
	}
	
}