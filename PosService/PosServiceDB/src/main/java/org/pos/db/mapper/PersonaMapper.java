package org.pos.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.pos.db.entidades.Persona;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class PersonaMapper implements ResultSetMapper<Persona> {
    	
	@Override
    public Persona map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Persona(
        		rs.getInt("idpersona"),
        		rs.getInt("idtipopersona"),
        		rs.getInt("idtipoidentificacion"),
        		rs.getLong("identificacion"),
        		rs.getString("nombre"),
        		rs.getString("direccion"),
        		rs.getString("telefono"),
        		rs.getString("correocontacto"),
        		rs.getString("contacto")
        		);
    }
}
