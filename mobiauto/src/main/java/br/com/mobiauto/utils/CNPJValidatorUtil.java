package br.com.mobiauto.utils;

import br.com.mobiauto.exception.CNPJInvalidException;

public class CNPJValidatorUtil {

	public static boolean isCNPJ(String cnpj) throws CNPJInvalidException {
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais ou com
		// tamanho diferente de 14
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.length() != 14))
			throw new CNPJInvalidException();
		
		
		//Se houver letras no CNPJ da como invalido
		if(!cnpj.matches("[0-9]+"))
			throw new CNPJInvalidException();
		
		return true;
	}

}
