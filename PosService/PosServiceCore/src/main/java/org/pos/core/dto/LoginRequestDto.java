package org.pos.core.dto;

public class LoginRequestDto {
	
	private String usuario;
	private String pass;

	public LoginRequestDto(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}

	public LoginRequestDto() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
