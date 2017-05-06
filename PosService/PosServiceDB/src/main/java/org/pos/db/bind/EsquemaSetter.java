package org.pos.db.bind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pos.com.PosSGlobal;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.StatementLocator;

/**
 * Se encarga de configurar el esquema de la BD
 */
public class EsquemaSetter implements StatementLocator {

	private Logger log = LogManager.getLogger(EsquemaSetter.class);
	
	@Override
    public String locate(String sql, StatementContext ctx) throws Exception {
		
//		String query = sql.replaceAll(PosSGlobal.ESQUEMA, ctx.getAttribute(PosSGlobal.ESQUEMA).toString());
//		log.info(query);
//		return query;
		
    	return sql.replaceAll(PosSGlobal.ESQUEMA, ctx.getAttribute(PosSGlobal.ESQUEMA).toString()); 
    }
}