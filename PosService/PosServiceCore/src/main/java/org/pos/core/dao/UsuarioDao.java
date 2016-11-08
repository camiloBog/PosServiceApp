package org.pos.core.dao;

import org.pos.core.entidades.Usuario;
import org.pos.core.mapper.UsuarioMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(UsuarioMapper.class)
public interface UsuarioDao {
    
//	@SqlUpdate("create table PERSON (id int auto_increment primary key, name varchar(80), email varchar(80), phone varchar(20))")
//    void createPersonTable();
//
//    @SqlUpdate("insert into PERSON (name, email, phone) values (:name, :email, :phone)")
//    void insert(@BindBean Usuario person);
//
//    @SqlUpdate("update PERSON set name = :p.name, email = :p.email, phone = :p.phone where id = :p.id")
//    void update(@BindBean("p") Usuario person);

	  
    @SqlQuery("select * from USUARIO where idusuario = :id")
    Usuario findById(@Bind("id") int id);
    
    @SqlQuery("select usuario from USUARIO where idusuario = :id")
    String getNameById(@Bind("id") int id);
    
    void close();

//    @SqlQuery("select * from PERSON")
//    List<Usuario> getAll();
//
//    @SqlUpdate("delete from PERSON where id = :it")
//    void deleteById(@Bind int id);
//
//    @SqlUpdate("delete from PERSON where email = :it")
//    void deleteByEmail(@Bind String email);
}