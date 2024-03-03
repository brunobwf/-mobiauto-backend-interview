package br.com.mobiauto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.model.Revenda;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface RevendaMapper {
	RevendaDTO revendaToDTO(Revenda revenda);
	
	@Mapping(target = "id", ignore = true)
	Revenda DTOToRevenda(RevendaDTO revendaDTO);
}
