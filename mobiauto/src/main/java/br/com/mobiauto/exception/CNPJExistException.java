package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

public class CNPJExistException extends SpecificException {
	private static final long serialVersionUID = 1L;

	public CNPJExistException() {
		super("CNPJ already registered in the database", HttpStatus.CONFLICT);
	}
}
