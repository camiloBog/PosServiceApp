package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Area;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class AreaMapper implements ResultSetMapper<Area> {
    
	@Override
    public Area map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Area(
        		rs.getInt("idarea"),
        		rs.getString("descripcion")
        		);
    }
}

