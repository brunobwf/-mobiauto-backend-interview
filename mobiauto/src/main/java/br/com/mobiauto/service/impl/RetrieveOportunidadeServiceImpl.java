package br.com.mobiauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.OportunidadeDTO;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.OportunidadeMapper;
import br.com.mobiauto.mapper.UsuarioMapper;
import br.com.mobiauto.model.Oportunidade;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.OportunidadeRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.RetrieveOportunidadeService;
import br.com.mobiauto.service.RetrieveUsuarioService;


@Service
public class RetrieveOportunidadeServiceImpl implements RetrieveOportunidadeService {

	
	@Autowired
	private OportunidadeRepository repository;
	
	@Autowired
	private OportunidadeMapper mapper;
	

	@Override
	public List<OportunidadeDTO> findAll() {
		List<Oportunidade> oportunidades = repository.findAll();
		List<OportunidadeDTO> oportunidadesDTO = mapper.listoportunidadeToListDTO(oportunidades);
		return oportunidadesDTO;
	}


	@Override
	public OportunidadeDTO findById(Long id) throws NotFoundException {
		Oportunidade oportunidade = repository.findById(id).orElseThrow(()-> new NotFoundException());
		OportunidadeDTO oportunidadeDTO = mapper.oportunidadeToDTO(oportunidade);
		return oportunidadeDTO;
	}	

}
