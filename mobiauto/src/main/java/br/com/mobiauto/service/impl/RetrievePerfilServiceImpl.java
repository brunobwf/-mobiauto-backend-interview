package br.com.mobiauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.PerfilMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.service.RetrievePerfilService;

@Service
public class RetrievePerfilServiceImpl implements RetrievePerfilService {

	
	@Autowired
	private PerfilRepository repository;
	
	@Autowired
	private PerfilMapper mapper;  
	
	@Override
	public List<PerfilDTO> findAll() {
		List<Perfil> perfis =  repository.findAll();
		List<PerfilDTO> perfisDTO = mapper.listPerfiltoListDTO(perfis);
		return perfisDTO;
	}

	@Override
	public PerfilDTO findById(Long id) throws NotFoundException {
		Perfil perfil = repository.findById(id).orElseThrow(()-> new NotFoundException());
		PerfilDTO perfilDTO = mapper.perfilToDTO(perfil);
		return perfilDTO;
	}

}
