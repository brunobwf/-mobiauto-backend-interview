package br.com.mobiauto.service;

import br.com.mobiauto.exception.NotFoundException;

public interface DeleteOportunidadeService {
	
	void delete(Long id) throws NotFoundException;
	
}
