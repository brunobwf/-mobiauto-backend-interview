package br.com.mobiauto.service;

import java.util.List;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.exception.NotFoundException;

public interface RetrievePerfilService {
	List<PerfilDTO> findAll();
	PerfilDTO findById(Long id) throws NotFoundException;
}
