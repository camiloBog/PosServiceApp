package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Producto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ProductoMapper implements ResultSetMapper<Producto> {
    
	@Override
    public Producto map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Producto(
        		rs.getInt("idproducto"),
        		rs.getString("descripcion"),
        		rs.getInt("idfabricante"),
        		rs.getInt("idtipomedida"),
        		rs.getBigDecimal("medida")
        		);
    }
}
