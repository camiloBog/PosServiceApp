package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Movimiento;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MovimientoMapper implements ResultSetMapper<Movimiento> {
	
	@Override
    public Movimiento map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Movimiento(
        		rs.getInt("idmovimiento"),
        		rs.getInt("idtipomovimiento"),
        		rs.getInt("idcliente"),
        		rs.getInt("idproveedor"),
        		rs.getTimestamp("fecha"),
        		rs.getInt("idusuario")
        		);
    }
}
