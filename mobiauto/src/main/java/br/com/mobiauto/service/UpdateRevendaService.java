package br.com.mobiauto.service;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;
import br.com.mobiauto.exception.NotFoundException;

public interface UpdateRevendaService {
	
	void updateRevenda(RevendaDTO revendaDTO, Long id) throws NotFoundException, CNPJInvalidException, CNPJExistException;

}
