package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.TipoIdentificacion;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TipoIdentificacionMapper implements ResultSetMapper<TipoIdentificacion> {
	
	@Override
    public TipoIdentificacion map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new TipoIdentificacion(
        		rs.getInt("ididentificacion"),
        		rs.getString("descripcion")
        		);
    }
}
