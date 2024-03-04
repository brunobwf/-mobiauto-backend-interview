package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistException extends SpecificException {
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistException() {
		super("User already registered in the database ", HttpStatus.CONFLICT);
	}
}
