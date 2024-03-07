package br.com.mobiauto.service;

import java.util.List;

import br.com.mobiauto.dto.OportunidadeDTO;
import br.com.mobiauto.exception.NotFoundException;

public interface RetrieveOportunidadeService {
	
	List<OportunidadeDTO> findAll();
	OportunidadeDTO findById(Long id) throws NotFoundException;

}
