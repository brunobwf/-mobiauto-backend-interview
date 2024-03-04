package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Status;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface StatusMapper {
	StatusDTO statusToDTO(Status status);
	
	List<StatusDTO> listStatustoListDTO(List<Status> status); 
	
	Status DTOToStatus(StatusDTO statusDTO);
}
