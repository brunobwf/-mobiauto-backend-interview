package br.com.mobiauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.mapper.RevendaMapper;
import br.com.mobiauto.mapper.UsuarioMapper;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.RetrieveUsuarioService;


@Service
public class RetrieveUsuarioServiceImpl implements RetrieveUsuarioService {

	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@Autowired
	private RevendaMapper revendaMapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email);
	}

	@Override
	public List<UsuarioResponseDTO> findAll() {
		List<Usuario> usuarios = repository.findAll();
		List<UsuarioResponseDTO> usuariosResponse = mapper.listUsuariosToResponse(usuarios);
		return usuariosResponse;
	}

	@Override
	public UsuarioResponseDTO findById(Long id) throws NotFoundException {
		Usuario usuario = repository.findById(id).orElseThrow(()-> new NotFoundException());
		UsuarioResponseDTO usuarioResponse = mapper.usuarioToResponse(usuario);
		return usuarioResponse;
	}
	
	

}
