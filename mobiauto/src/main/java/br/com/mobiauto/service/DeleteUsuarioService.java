package br.com.mobiauto.service;

import br.com.mobiauto.exception.NotFoundException;

public interface DeleteUsuarioService {
	
	void delete(Long id) throws NotFoundException;

}
