package br.com.mobiauto.handler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.mobiauto.error.ApiErrorMessage;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({SQLIntegrityConstraintViolationException.class,IllegalArgumentException.class})
	public ResponseEntity<ApiErrorMessage> handleExceptions(Exception ex, WebRequest request) {

		List<String> errors = new ArrayList<String>();
		String error = ex.getLocalizedMessage();
		errors.add(error);
		ApiErrorMessage errormessage = new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, errors);
		return new ResponseEntity<ApiErrorMessage>(errormessage, errormessage.getStatus());
	}

	@ExceptionHandler({NotFoundException.class,CNPJInvalidException.class,CNPJExistException.class, EmailInvalidException.class, EmailAlreadyExistException.class})
	public ResponseEntity<ApiErrorMessage> handleSpecificExceptions(SpecificException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		String error = ex.getErrorMessage();
		errors.add(error);
		ApiErrorMessage errormessage = new ApiErrorMessage(ex.getHttpStatus(), errors);
		return new ResponseEntity<ApiErrorMessage>(errormessage, errormessage.getStatus());
	}
}