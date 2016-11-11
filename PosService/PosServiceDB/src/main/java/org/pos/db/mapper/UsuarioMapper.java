package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Usuario;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class UsuarioMapper implements ResultSetMapper<Usuario> {
	
	@Override
    public Usuario map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Usuario(
        		rs.getInt("idusuario"),
        		rs.getString("usuario"),
        		rs.getString("nombre"),
        		rs.getString("apellidos"),
        		rs.getString("contrasena"), 
        		rs.getInt("idarea"),
        		rs.getInt("idtenant")
        		);
    }
}
