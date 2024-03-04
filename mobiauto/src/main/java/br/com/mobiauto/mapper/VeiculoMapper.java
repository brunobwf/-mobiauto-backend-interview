package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.ClienteDTO;
import br.com.mobiauto.dto.VeiculoDTO;
import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Veiculo;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface VeiculoMapper {
	VeiculoDTO veiculoToDTO(Veiculo veiculo);
	
	List<VeiculoDTO> listVeiculotoListDTO(List<Veiculo> veiculo); 
	
	@Mapping(target = "id", ignore = true)
	Veiculo DTOToVeiculo(VeiculoDTO veiculoDTO);
}
