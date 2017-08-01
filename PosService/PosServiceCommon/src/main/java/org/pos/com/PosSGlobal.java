package org.pos.com;

public class PosSGlobal {
	
	/**
	 * JNDI del datasource de la base de datos de PosService
	 */
	public static final String DB_JNDI = "java:/jndi/PosServiceDS";
	
	/**
	 * Valor que sera buscado en EsquemaSetter.class para proveer el valor del esquema
	 */ 
	public static final String ESQUEMA = ":NombreDeEsquema";
	
	/**
	 * Nombre del esquema base en la BD de PosService
	 */
	public static final String ESQUEMA_BASE = "public";
	
	/**
	 * Numero identificador del cliente.
	 */
	public static final Integer TIPO_CLIENTE = 1;
	
	/**
	 * Numero identificador del proveedor
	 */
	public static final Integer TIPO_PROVEEDOR = 2;
	
	/**
	 * Numero identificador del cliente.
	 */
	public static final Integer TIPO_COMPRA = 1;
	
	/**
	 * Numero identificador del proveedor
	 */
	public static final Integer TIPO_VENTA = 2;
	
}
