package br.com.mobiauto.service;

import br.com.mobiauto.dto.OportunidadeRequestUpdateDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;

public interface UpdateOportunidadeService {
	
	void transferirOportunidade(OportunidadeRequestUpdateDTO oportunidadeDTO, Long id) throws NotFoundException;
	void mudarStatusOportunidade(OportunidadeRequestUpdateDTO oportunidadeDTO, Long id) throws NotFoundException, SpecificException;
	

}
