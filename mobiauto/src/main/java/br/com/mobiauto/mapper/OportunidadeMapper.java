package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.ClienteDTO;
import br.com.mobiauto.dto.OportunidadeDTO;
import br.com.mobiauto.dto.OportunidadeNovaDTO;
import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Oportunidade;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface OportunidadeMapper {
	OportunidadeNovaDTO oportunidadeToNovaDTO(Oportunidade oportunidade);
	 
	@Mapping(target = "id", ignore = true)
	Oportunidade NovaDTOToOportunidade(OportunidadeNovaDTO oportunidadeNovaDTO);
	
	List<OportunidadeDTO> listoportunidadeToListDTO(List<Oportunidade> oportunidades);
	
	OportunidadeDTO oportunidadeToDTO(Oportunidade oportunidade);
}
