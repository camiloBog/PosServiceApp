package org.pos.core.bind;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.StatementLocator;

public class EsquemaSetter implements StatementLocator {

	@Override
    public String locate(String sql, StatementContext ctx) throws Exception {
		
    	return sql.replaceAll(":esquema", ctx.getAttribute("esquema").toString()); 

    }
}