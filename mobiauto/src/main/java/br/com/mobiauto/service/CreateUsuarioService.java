package br.com.mobiauto.service;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;

public interface CreateUsuarioService {

	void save(UsuarioDTO usuarioDTO) throws NotFoundException, EmailInvalidException, EmailAlreadyExistException;
	
}
