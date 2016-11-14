package org.pos.db.bind;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.pos.com.PosSGlobal;
import org.skife.jdbi.v2.DBI;

/**
 * Se encarga de proveer un DBI que apunta al esquema indicado
 *
 */
public class DbiProvider {
	
	private DbiProvider() {}

	private static DBI createDBI() {
		
		DBI dbi = null;
		DataSource ds = null;
		
		try {
			ds = (DataSource) new InitialContext().lookup(PosSGlobal.DB_JNDI);
			dbi = new DBI(ds);
			return dbi;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retorna un BDI para el esquema de la BD indicado
	 * 
	 * @param DbEsquema	Nombre del esquema de la BD al que se le hara la consulta
	 * @return	DBI
	 */
	public static DBI getDBI(String DbEsquema) {
		DBI dbi = createDBI();
		dbi.define(PosSGlobal.ESQUEMA, DbEsquema);
		return dbi;
    }
	
	/**
	 * Retorna un BDI para el esquema base de la BD
	 * 
	 * @return	DBI
	 */
	public static DBI getDBI() {
		DBI dbi = createDBI();
		dbi.define(PosSGlobal.ESQUEMA, PosSGlobal.ESQUEMA_BASE);
		return dbi;
    }
	
	/**
	 * Retorna un BDI para el esquema base de la BD
	 * 
	 * @return	DBI
	 */
	public static DBI getSimpleDBI() {
		DBI dbi = createDBI();
		dbi.define(PosSGlobal.ESQUEMA, PosSGlobal.ESQUEMA_BASE);
		return dbi;
    }
	
}
