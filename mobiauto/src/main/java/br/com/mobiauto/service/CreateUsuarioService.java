package br.com.mobiauto.service;

import java.util.Map;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;
import jakarta.servlet.http.HttpServletRequest;

public interface CreateUsuarioService {

	void save(UsuarioDTO usuarioDTO, Map<String,String> headers) throws NotFoundException, EmailInvalidException, EmailAlreadyExistException, SpecificException;
	
}
