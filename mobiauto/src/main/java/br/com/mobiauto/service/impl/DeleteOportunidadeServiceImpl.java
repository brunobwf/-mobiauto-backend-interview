package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Oportunidade;
import br.com.mobiauto.repository.OportunidadeRepository;
import br.com.mobiauto.service.DeleteOportunidadeService;

@Service
public class DeleteOportunidadeServiceImpl implements DeleteOportunidadeService {

	
	@Autowired
	private OportunidadeRepository repository;
	
	@Override
	public void delete(Long id) throws NotFoundException {
		Oportunidade oportunidade = repository.findById(id).orElseThrow(()-> new NotFoundException());
	repository.delete(oportunidade);
		
	}
	
	
	

}
