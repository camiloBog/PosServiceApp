package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Almacen;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class AlmacenMapper implements ResultSetMapper<Almacen> {
    
	@Override
    public Almacen map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Almacen(
        		rs.getInt("idalmacen"),
        		rs.getInt("contacto"),
        		rs.getLong("descripcion"),
        		rs.getLong("direccion"),
        		rs.getString("mail"),
        		rs.getString("telefono"),
        		rs.getInt("idciudad")
        		);
    }
}
