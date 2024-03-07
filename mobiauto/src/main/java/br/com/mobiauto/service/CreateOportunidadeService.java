package br.com.mobiauto.service;

import br.com.mobiauto.dto.OportunidadeNovaDTO;
import br.com.mobiauto.exception.NotFoundException;


public interface CreateOportunidadeService {
	void save(OportunidadeNovaDTO oportunidadeNovaDto) throws NotFoundException, Exception;
}
