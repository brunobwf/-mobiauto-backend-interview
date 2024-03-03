package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.service.DeleteRevendaService;

@Service
public class DeleteRevendaServiceImpl implements DeleteRevendaService{

	@Autowired
	private RevendaRepository repository;

	@Override
	public void deleteRevenda(Long id) throws NotFoundException {
		Revenda revenda = repository.findById(id).orElseThrow(()-> new NotFoundException());
		repository.delete(revenda);
		
	}
	
	
}
