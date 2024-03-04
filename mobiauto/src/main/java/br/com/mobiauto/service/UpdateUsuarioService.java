package br.com.mobiauto.service;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;

public interface UpdateUsuarioService {
	
	void updateUsuario (UsuarioDTO usuarioDTO,Long id) throws EmailInvalidException, EmailAlreadyExistException, NotFoundException;

}
