package br.com.mobiauto.service;

import org.springframework.data.domain.Page;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Revenda;


public interface RetrieveRevendaService {
	
	Page<Revenda> findAllPagination(Integer pageNumber, Integer pageSize, String sort);
	RevendaDTO findRevenda(Long id) throws NotFoundException;

}
