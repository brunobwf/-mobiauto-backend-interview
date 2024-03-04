package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.DeleteUsuarioService;

@Service
public class DeleteUsuarioServiceImpl implements DeleteUsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public void delete(Long id) throws NotFoundException {
		Usuario usuario = repository.findById(id).orElseThrow(() -> new NotFoundException());
		repository.delete(usuario);
	}

}
