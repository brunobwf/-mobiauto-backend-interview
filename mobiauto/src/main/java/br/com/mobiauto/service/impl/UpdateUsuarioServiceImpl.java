package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.UpdateUsuarioService;
import br.com.mobiauto.utils.EmailValidatorUtil;

@Service
public class UpdateUsuarioServiceImpl implements UpdateUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private RevendaRepository revendaRepository;
	
	@Override
	public void updateUsuario(UsuarioDTO usuarioDTO, Long id)
			throws EmailInvalidException, EmailAlreadyExistException, NotFoundException {

		String usuarioEmail = usuarioDTO.getEmail();
		Perfil perfil;
		Revenda revenda;
		EmailValidatorUtil.isValid(usuarioEmail);

		UserDetails userDetails = repository.findByEmail(usuarioEmail);

		if (userDetails != null) {
			throw new EmailAlreadyExistException();
		}

		Usuario usuario = repository.findById(id)
				.orElseThrow(() -> new NotFoundException());

		if (usuarioDTO.getEmail() != null) {
			usuario.setEmail(usuarioEmail);
		}

		if (usuarioDTO.getNome() != null) {
			usuario.setNome(usuarioDTO.getNome());
		}

		if (usuarioDTO.getNome() != null) {
			usuario.setSenha(usuarioDTO.getSenha());
		}
		
		if(usuarioDTO.getIdPerfil() != null) {
			perfil = perfilRepository.findById(usuarioDTO.getIdPerfil()).orElseThrow(() -> new NotFoundException("Perfil not exist in database"));
			usuario.setPerfil(perfil);
		}
		
		if(usuarioDTO.getIdRevenda() != null) {
			revenda = revendaRepository.findById(usuarioDTO.getIdRevenda()).orElseThrow(() -> new NotFoundException("Store not exist in database"));
			usuario.setRevenda(revenda);
		}

		repository.save(usuario);
		
	}

}
