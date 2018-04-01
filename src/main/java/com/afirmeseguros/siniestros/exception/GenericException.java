package com.afirmeseguros.siniestros.exception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1949763546520829279L;

	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericException(String message) {
		super(message);
	}



}
