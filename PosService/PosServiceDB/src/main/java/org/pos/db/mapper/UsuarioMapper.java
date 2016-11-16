package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Usuarios;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class UsuarioMapper implements ResultSetMapper<Usuarios> {
	
	@Override
    public Usuarios map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Usuarios(
        		rs.getInt("idusuario"),
        		rs.getString("usuario"),
        		rs.getString("nombre"),
        		rs.getString("apellidos"),
        		rs.getString("contrasena"), 
        		rs.getInt("idperfil"),
        		rs.getInt("idtenant")
        		);
    }
}
