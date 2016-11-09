package org.pos.core.bind;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

/**
 * Singleton para generar el DBI
 *
 */
public class DbiSingleton {
    
	private final static String DB_JNDI = "java:/jndi/PosServiceDS";
	private static DBI dbi = null;
	
	private DbiSingleton() {}

	private static void createDBI() {
		DataSource ds = null;
		try {
			ds = (DataSource) new InitialContext().lookup(DB_JNDI);
			dbi = new DBI(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DBI getDBI() {
		if( null == dbi) createDBI();
		return DbiSingleton.dbi;
    }
	
}
