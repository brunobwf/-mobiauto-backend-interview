package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.RevendaMapper;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.service.RetrieveRevendaService;

@Service
public class RetrieveRevendaServiceImpl implements RetrieveRevendaService {

	@Autowired
	private RevendaRepository repository;
	
	@Autowired
	private RevendaMapper mapper;

	@Override
	public Page<Revenda> findAllPagination(Integer pageNumber, Integer pageSize, String sort) {
		Pageable pageable = null;
		if (sort != null) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC);
		} else {
			pageable = PageRequest.of(pageNumber, pageSize);
		}
		return repository.findAll(pageable);
	}

	@Override
	public RevendaDTO findRevenda(Long id) throws NotFoundException {
		Revenda revenda = repository.findById(id).orElseThrow(()-> new NotFoundException());
		return mapper.revendaToDTO(revenda);
	}

}
