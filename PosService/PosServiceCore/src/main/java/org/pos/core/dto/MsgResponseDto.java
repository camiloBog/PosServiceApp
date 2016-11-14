package org.pos.core.dto;

public class MsgResponseDto {

	private String mensaje;
	private boolean validacion;
	private Object objeto;
	
	public MsgResponseDto() {

	}

	public MsgResponseDto(String mensaje, boolean validacion, Object objeto) {
		this.mensaje = mensaje;
		this.validacion = validacion;
		this.objeto = objeto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isValidacion() {
		return validacion;
	}

	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

}
