package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.mapper.PerfilMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.service.CreatePerfilService;


@Service
public class CreatePerfilServiceImpl implements CreatePerfilService {

	
	@Autowired
	private PerfilRepository repository;
	
	@Autowired
	private PerfilMapper mapper;
	
	@Override
	public void save(PerfilDTO perfilDto) {
		Perfil perfil = mapper.DTOToPerfil(perfilDto);
		repository.save(perfil);
	}

}
