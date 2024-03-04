package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.mapper.PerfilMapper;
import br.com.mobiauto.mapper.StatusMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.StatusRepository;
import br.com.mobiauto.service.CreatePerfilService;
import br.com.mobiauto.service.CreateStatusService;


@Service
public class CreateStatusServiceImpl implements CreateStatusService {

	
	@Autowired
	private StatusRepository repository;
	
	@Autowired
	private StatusMapper mapper;
	
	@Override
	public void save(StatusDTO statusDto) {
		Status status = mapper.DTOToStatus(statusDto);
		repository.save(status);
	}

}
