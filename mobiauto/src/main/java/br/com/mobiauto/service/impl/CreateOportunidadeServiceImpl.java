package br.com.mobiauto.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.OportunidadeNovaDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.OportunidadeMapper;
import br.com.mobiauto.mapper.UsuarioMapper;
import br.com.mobiauto.model.Oportunidade;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.OportunidadeRepository;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.repository.StatusRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.CreateOportunidadeService;
import br.com.mobiauto.service.CreateUsuarioService;
import br.com.mobiauto.utils.EmailValidatorUtil;

@Service
public class CreateOportunidadeServiceImpl implements CreateOportunidadeService {

	@Autowired
	private OportunidadeRepository repository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RevendaRepository revendaRepository;
	
	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private OportunidadeMapper mapper;


	@Override
	public void save(OportunidadeNovaDTO oportunidadeNovaDto) throws Exception, NotFoundException {
		Oportunidade oportunidade = mapper.NovaDTOToOportunidade(oportunidadeNovaDto);
		Usuario usuario = null;
		//Validar se o usuário existe para ser responsavel. Caso seja passado um responsavel na criação da oportunidade ja é passado tambem a data da atribuição.
		if(oportunidadeNovaDto.getIdUsuarioResponsavel() != null) {
			 usuario = usuarioRepository.findById(oportunidadeNovaDto.getIdUsuarioResponsavel()).orElseThrow(()-> new NotFoundException("Non-existing user to be responsible for the opportunity"));
			oportunidade.setUsuario(usuario);
			LocalDate now = LocalDate.now(); 
			oportunidade.setDataAtrib(now);
		}	
			String statusName = "NOVO";
			Status status = statusRepository.findByNome(statusName).orElseThrow(()-> new Exception("Problem finding Status " + statusName +" in the database"));
			oportunidade.setStatus(status);
			
			Revenda revenda = usuario.getRevenda();
			revenda.getOportunidades().add(oportunidade);
			repository.save(oportunidade);
			revendaRepository.save(revenda);
			
	}

}
