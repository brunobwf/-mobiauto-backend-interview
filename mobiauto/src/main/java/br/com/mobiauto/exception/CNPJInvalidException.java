package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

public class CNPJInvalidException extends EspecificException {
	private static final long serialVersionUID = 1L;

	public CNPJInvalidException() {
		super("Error, Invalid CNPJ", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
