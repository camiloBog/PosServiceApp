package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.TipoPersonas;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TipoPersonasMapper implements ResultSetMapper<TipoPersonas> {

	@Override
    public TipoPersonas map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new TipoPersonas(
        		rs.getInt("idtipopersona"),
        		rs.getString("descripcion")
        		);
    }
}
