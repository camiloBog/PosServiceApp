package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.TipoMedida;
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
