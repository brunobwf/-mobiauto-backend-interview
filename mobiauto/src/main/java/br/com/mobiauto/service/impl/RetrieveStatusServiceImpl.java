package br.com.mobiauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.PerfilMapper;
import br.com.mobiauto.mapper.StatusMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.StatusRepository;
import br.com.mobiauto.service.RetrievePerfilService;
import br.com.mobiauto.service.RetrieveStatusService;

@Service
public class RetrieveStatusServiceImpl implements RetrieveStatusService {

	
	@Autowired
	private StatusRepository repository;
	
	@Autowired
	private StatusMapper mapper;  
	
	@Override
	public List<StatusDTO> findAll() {
		List<Status> status =  repository.findAll();
		List<StatusDTO> statusDTO = mapper.listStatustoListDTO(status);
		return statusDTO;
	}

	@Override
	public StatusDTO findById(Long id) throws NotFoundException {
		Status status = repository.findById(id).orElseThrow(()-> new NotFoundException());
		StatusDTO statusDTO = mapper.statusToDTO(status);
		return statusDTO;
	}

}
