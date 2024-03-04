package br.com.mobiauto.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NotFoundException extends SpecificException {
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super("information not found in the database", HttpStatus.NOT_FOUND);
	}
	
	public NotFoundException(String specificMessage) {
		super(specificMessage, HttpStatus.NOT_FOUND);
		
	}

}
