package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.Usuario;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class UsuarioMapper implements ResultSetMapper<Usuario> {
    
	@Override
    public Usuario map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Usuario(
        		rs.getInt("idusuario"),
        		rs.getString("apellidos"),
        		rs.getString("contrasena"),
        		rs.getString("nombre"),
        		rs.getString("usuario"), 
        		rs.getInt("idarea"),
        		rs.getInt("idtenant")
        		);
    }
}
