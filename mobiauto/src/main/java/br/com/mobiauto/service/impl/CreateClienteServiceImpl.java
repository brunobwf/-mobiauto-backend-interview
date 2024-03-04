package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.ClienteDTO;
import br.com.mobiauto.mapper.ClienteMapper;
import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.repository.ClienteRepository;
import br.com.mobiauto.service.CreateClienteService;


@Service
public class CreateClienteServiceImpl implements CreateClienteService {

	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteMapper mapper;
	
	@Override
	public void save(ClienteDTO clienteDto) {
		Cliente cliente = mapper.DTOToCliente(clienteDto);
		repository.save(cliente);
	}

}
