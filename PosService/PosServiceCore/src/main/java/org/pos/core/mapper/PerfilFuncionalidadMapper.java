package org.pos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.core.entidades.PerfilFuncionalidad;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class PerfilFuncionalidadMapper implements ResultSetMapper<PerfilFuncionalidad> {
    
	@Override
    public PerfilFuncionalidad map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new PerfilFuncionalidad(
        		rs.getInt("idperfil"),
        		rs.getInt("idfuncionalidad"),
        		rs.getBoolean("borra"),
        		rs.getBoolean("inserta"),
        		rs.getBoolean("modificia")
        		);
    }
}
