package br.com.mobiauto.service;

import br.com.mobiauto.exception.NotFoundException;

public interface DeleteRevendaService {
	
	void deleteRevenda(Long id) throws NotFoundException;
}
