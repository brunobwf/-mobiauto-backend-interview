package br.com.mobiauto.utils;

import br.com.mobiauto.exception.EmailInvalidException;

public class EmailValidatorUtil {

	public static boolean isValid(String email) throws EmailInvalidException {
		if (email.contains("@") && email.contains(".com")) {
			return true;
		} else {
			throw new EmailInvalidException();
		}

	}
}
