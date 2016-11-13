package org.pos.com;

public class PosSGlobal {
	
	/**
	 * JNDI del datasource de la base de datos de PosService
	 */
	public static final String DB_JNDI = "java:/jndi/PosServiceDS";
	
	/**
	 * Valor que sera buscado en EsquemaSetter.class para proveer el valor del esquema
	 */
	public static final String ESQUEMA = ":esquema";
	
	/**
	 * Nombre del esquema base en la BD de PosService
	 */
	public static final String ESQUEMA_BASE = "public";
	
}
