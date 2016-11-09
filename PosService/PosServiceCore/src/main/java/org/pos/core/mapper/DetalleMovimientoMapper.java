package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.DetalleMovimiento;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class DetalleMovimientoMapper implements ResultSetMapper<DetalleMovimiento> {
    		
	@Override
    public DetalleMovimiento map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new DetalleMovimiento(
        		rs.getInt("idmovimiento"),
        		rs.getInt("iddetalle"),
        		rs.getInt("idalmacen"),
        		rs.getInt("idproducto"),
        		rs.getInt("cantidad"),
        		rs.getBigDecimal("valorcompra"),
        		rs.getBigDecimal("valorventa")
        		);
    }
}
