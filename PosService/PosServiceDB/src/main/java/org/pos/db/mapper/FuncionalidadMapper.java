package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Funcionalidad;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class FuncionalidadMapper implements ResultSetMapper<Funcionalidad> {
    
	@Override
    public Funcionalidad map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Funcionalidad(
        		rs.getInt("idfuncionalidad"),
        		rs.getString("descripcion"),
        		rs.getInt("idmodulo")
        		);
    }
}
