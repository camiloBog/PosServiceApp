package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Perfiles;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class PerfilesMapper implements ResultSetMapper<Perfiles> {
    
	@Override
    public Perfiles map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Perfiles(
        		rs.getInt("idperfil"),
        		rs.getString("descripcion")
        		);
    }
}
