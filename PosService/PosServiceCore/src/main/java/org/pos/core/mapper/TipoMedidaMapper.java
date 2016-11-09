package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.TipoMedida;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TipoMedidaMapper implements ResultSetMapper<TipoMedida> {

	@Override
    public TipoMedida map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new TipoMedida(
        		rs.getInt("idtipomedida"),
        		rs.getString("descripcion")
        		);
    }
}
