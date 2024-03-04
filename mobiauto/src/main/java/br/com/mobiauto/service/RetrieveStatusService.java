package br.com.mobiauto.service;

import java.util.List;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.exception.NotFoundException;

public interface RetrieveStatusService {
	List<StatusDTO> findAll();
	StatusDTO findById(Long id) throws NotFoundException;
}
