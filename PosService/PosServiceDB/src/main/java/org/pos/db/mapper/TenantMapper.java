package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Tenant;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TenantMapper implements ResultSetMapper<Tenant> {
		
	@Override
    public Tenant map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Tenant(
        		rs.getInt("idtenant"),
        		rs.getInt("tipoidentificacion"),
        		rs.getString("identificacion"),
        		rs.getString("nombre"),
        		rs.getString("direccion"),
        		rs.getString("telefono"),
        		rs.getString("esquema")
        		);
    }
}
