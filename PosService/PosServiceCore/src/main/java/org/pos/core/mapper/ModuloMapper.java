package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.Modulo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ModuloMapper implements ResultSetMapper<Modulo> {
    
	@Override
    public Modulo map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Modulo(
        		rs.getInt("idmodulo"),
        		rs.getString("descripcion")
        		);
    }
}
