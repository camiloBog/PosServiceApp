package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.AlmacenProducto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class AlmacenProductoMapper implements ResultSetMapper<AlmacenProducto> {
    	
	@Override
    public AlmacenProducto map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new AlmacenProducto(
        		rs.getInt("idalmacen"),
        		rs.getInt("idproducto"),
        		rs.getBigDecimal("cantidad"),
        		rs.getBigDecimal("stockmaximo"),
        		rs.getBigDecimal("stockminimo"),
        		rs.getBigDecimal("valorcompra")
        		);
    }
}
