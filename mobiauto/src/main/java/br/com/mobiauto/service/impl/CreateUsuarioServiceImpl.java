package br.com.mobiauto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.UsuarioMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.CreateUsuarioService;
import br.com.mobiauto.utils.EmailValidatorUtil;

@Service
public class CreateUsuarioServiceImpl implements CreateUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private RevendaRepository revendaRepository;

	@Autowired
	private UsuarioMapper mapper;

	@Override
	public void save(UsuarioDTO usuarioDTO) throws NotFoundException, EmailInvalidException, EmailAlreadyExistException {
		
		String usuarioEmail = usuarioDTO.getEmail();
		EmailValidatorUtil.isValid(usuarioEmail);
		
		
		UserDetails userDetails = repository.findByEmail(usuarioEmail);
		
		if(userDetails != null) {
			throw new EmailAlreadyExistException();
		}
		
		Usuario usuario = mapper.dTOToUsuario(usuarioDTO);
		Revenda revenda = null;
		Perfil perfil = null;
		
		// Validações para ver se a Revenda o Perfil preenchido existe
		
		if(usuarioDTO.getIdPerfil() != null) {
			perfil = perfilRepository.findById(usuarioDTO.getIdPerfil()).orElseThrow(() -> new NotFoundException("Perfil not exist in database"));
		}
		
		if(usuarioDTO.getIdRevenda() != null) {
			revenda = revendaRepository.findById(usuarioDTO.getIdRevenda()).orElseThrow(() -> new NotFoundException("Store not exist in database"));
		}
		
		usuario.setPerfil(perfil);
		usuario.setRevenda(revenda);

		repository.save(usuario);

	}

}
