package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

public class CNPJInvalidException extends SpecificException {
	private static final long serialVersionUID = 1L;

	public CNPJInvalidException() {
		super("Error, Invalid CNPJ", HttpStatus.BAD_REQUEST);
	}
}
