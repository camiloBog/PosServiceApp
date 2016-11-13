package org.pos.db.dao;

import java.util.List;

import org.pos.com.PosSGlobal;
import org.pos.db.bind.DaoInterface;
import org.pos.db.bind.EsquemaSetter;
import org.pos.db.entidades.Usuario;
import org.pos.db.mapper.UsuarioMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementLocatorWith;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UsuarioMapper.class)
@OverrideStatementLocatorWith(EsquemaSetter.class)
public interface UsuarioDao extends DaoInterface{
	
	@SqlUpdate("insert into "+PosSGlobal.ESQUEMA+".USUARIO (idusuario, apellidos, contrasena, nombre, usuario, idarea, idtenant) "
			+ "values (:idusuario, :apellidos, :contrasena, :nombre, :usuario, :idarea, :idtenant)")
	public void insert(@BindBean Usuario usuario);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO where idusuario = :id")
	public Usuario findById(@Bind("id") int id);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO where usuario = :usuario and contrasena = :contrasena")
	public Usuario validate(@Bind("usuario") String usuario, @Bind("contrasena") String contrasena);
	
	@SqlQuery("select * from "+PosSGlobal.ESQUEMA+".USUARIO")
	public List<Usuario> findAll();
	
	@SqlUpdate("update "+PosSGlobal.ESQUEMA+".USUARIO set apellidos = :u.apellidos, "
			+ "contrasena = :u.contrasena, nombre = :u.nombre, "
			+ "idarea = :u.idarea, idtenant = :u.idtenant "
			+ "where usuario = :u.usuario and idusuario = :u.idusuario")
	public void update(@BindBean("u") Usuario usuario);
	
	@SqlUpdate("delete from "+PosSGlobal.ESQUEMA+".USUARIO where idusuario = :idusuario")
	public void deleteById(@Bind("idusuario") int idusuario);

}