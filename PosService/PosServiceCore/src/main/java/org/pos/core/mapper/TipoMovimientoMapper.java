package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.TipoMovimiento;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TipoMovimientoMapper implements ResultSetMapper<TipoMovimiento> {

	@Override
    public TipoMovimiento map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new TipoMovimiento(
        		rs.getInt("idmovimiento"),
        		rs.getString("descripcion")
        		);
    }
}
