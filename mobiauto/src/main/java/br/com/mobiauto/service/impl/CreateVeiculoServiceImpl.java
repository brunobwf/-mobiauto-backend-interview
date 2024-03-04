package br.com.mobiauto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.ClienteDTO;
import br.com.mobiauto.dto.VeiculoDTO;
import br.com.mobiauto.mapper.ClienteMapper;
import br.com.mobiauto.mapper.VeiculoMapper;
import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Veiculo;
import br.com.mobiauto.repository.ClienteRepository;
import br.com.mobiauto.repository.VeiculoRepository;
import br.com.mobiauto.service.CreateClienteService;
import br.com.mobiauto.service.CreateVeiculoService;


@Service
public class CreateVeiculoServiceImpl implements CreateVeiculoService {

	
	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private VeiculoMapper mapper;

	@Override
	public void save(VeiculoDTO veiculoDto) {
		Veiculo veiculo = mapper.DTOToVeiculo(veiculoDto);
		repository.save(veiculo);
		
	}
	


}
