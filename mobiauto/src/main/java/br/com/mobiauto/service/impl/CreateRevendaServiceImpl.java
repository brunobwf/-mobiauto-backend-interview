package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;
import br.com.mobiauto.mapper.RevendaMapper;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.service.CreateRevendaService;
import br.com.mobiauto.utils.CNPJValidatorUtil;

@Service
public class CreateRevendaServiceImpl implements CreateRevendaService {

	@Autowired
	private RevendaRepository repository;

	@Autowired
	private RevendaMapper mapper;

	@Override
	public void save(RevendaDTO revendaDTO) throws CNPJExistException, CNPJInvalidException {
		
		//Valida se o CNPJ tem 14 caracteres, não possui letras e não é números únicos repitidos.
		Boolean validCNPJ = CNPJValidatorUtil.isCNPJ(revendaDTO.getCnpjRevenda());
		if(validCNPJ == false) {
			throw new CNPJInvalidException();
		}
		
		//Valida se o CNPJ já está na base dados
		Revenda existingCnpj = repository.findByCnpjRevenda(revendaDTO.getCnpjRevenda());
		if(existingCnpj != null) {
			throw new CNPJExistException();
		}
		

		
		Revenda revenda = mapper.DTOToRevenda(revendaDTO);
		repository.save(revenda);

	}

}
