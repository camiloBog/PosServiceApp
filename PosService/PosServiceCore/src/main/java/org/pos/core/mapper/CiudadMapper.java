package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.Ciudad;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CiudadMapper implements ResultSetMapper<Ciudad> {
	@Override
    public Ciudad map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Ciudad(
        		rs.getInt("idciudad"),
        		rs.getString("descripcion")
        		);
    }
}
