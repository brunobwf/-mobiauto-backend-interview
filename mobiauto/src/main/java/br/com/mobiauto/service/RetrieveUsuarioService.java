package br.com.mobiauto.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.exception.NotFoundException;

public interface RetrieveUsuarioService extends UserDetailsService {
	
	List<UsuarioResponseDTO> findAll();
	UsuarioResponseDTO findById(Long id) throws NotFoundException;
	
}
