package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.service.UpdateRevendaService;
import br.com.mobiauto.utils.CNPJValidatorUtil;

@Service
public class UpdateRevendaServiceImpl implements UpdateRevendaService {

	@Autowired
	private RevendaRepository repository;

	@Override
	public void updateRevenda(RevendaDTO revendaDTO, Long id) throws NotFoundException, CNPJInvalidException, CNPJExistException {

		// Valida se o CNPJ tem 14 caracteres, não possui letras e não é números únicos
		// repitidos.
		Boolean validCNPJ = CNPJValidatorUtil.isCNPJ(revendaDTO.getCnpjRevenda());
		if (validCNPJ == false) {
			throw new CNPJInvalidException();
		}
		
		
		Revenda revenda = repository.findById(id).orElseThrow(() -> new NotFoundException());
		
		//Valida se o CNPJ já está na base dados e não é o mesmo que será editado( evitar duplicatas de CNPJ)
		Revenda existingCnpj = repository.findByCnpjRevenda(revendaDTO.getCnpjRevenda());
		if(existingCnpj.getId() != revenda.getId()) {
			throw new CNPJExistException();
		}

		if (revendaDTO.getCnpjRevenda() != null) {
			revenda.setCnpjRevenda(revendaDTO.getCnpjRevenda());
		}

		if (revendaDTO.getNomeSocial() != null) {
			revenda.setNomeSocial(revendaDTO.getNomeSocial());
		}

		repository.save(revenda);
	}

}
