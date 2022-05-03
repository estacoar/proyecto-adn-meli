package com.analizaradn.api.dominio;

public class ValidadorArgumentosExcepcion extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ValidadorArgumentosExcepcion(String mensaje) {
		super(mensaje);
	}
}
