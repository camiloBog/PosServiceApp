package org.pos.core.dao;

import java.util.List;

import org.pos.core.entidades.Usuario;
import org.pos.core.mapper.UsuarioMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(UsuarioMapper.class)
public interface UsuarioDao extends DaoInterface{
	
	@SqlUpdate("insert into USUARIO (idusuario, apellidos, contrasena, nombre, usuario, idarea, idtenant) "
			+ "values (:idusuario, :apellidos, :contrasena, :nombre, :usuario, :idarea, :idtenant)")
	public void insert(@BindBean Usuario usuario);
	
	@SqlQuery("select * from USUARIO where idusuario = :id")
	public Usuario findById(@Bind("id") int id);
	
	@SqlQuery("select * from USUARIO where usuario = :usuario and contrasena = :contrasena")
	public Usuario validate(@Bind("usuario") String usuario, @Bind("contrasena") String contrasena);
	
	@SqlQuery("select * from :esquema.USUARIO where usuario = :usuario and contrasena = :contrasena")
	public Usuario validate2(@Bind("esquema") String esquema, @Bind("usuario") String usuario, @Bind("contrasena") String contrasena);
	
	@SqlQuery("select * from USUARIO")
	public List<Usuario> findAll();
	
	@SqlUpdate("update USUARIO set apellidos = :u.apellidos, "
			+ "contrasena = :u.contrasena, nombre = :u.nombre, "
			+ "idarea = :u.idarea, idtenant = :u.idtenant "
			+ "where usuario = :u.usuario and idusuario = :u.idusuario")
	public void update(@BindBean("u") Usuario usuario);
	
	@SqlUpdate("delete from USUARIO where idusuario = :idusuario")
	public void deleteById(@Bind("idusuario") int idusuario);

}