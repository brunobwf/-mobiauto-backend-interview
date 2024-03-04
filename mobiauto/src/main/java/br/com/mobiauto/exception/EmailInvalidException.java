package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

public class EmailInvalidException extends SpecificException {
	private static final long serialVersionUID = 1L;

	public EmailInvalidException() {
		super("Error, Invalid Email. Please don't forget the @ and .com ", HttpStatus.BAD_REQUEST);
	}
}
