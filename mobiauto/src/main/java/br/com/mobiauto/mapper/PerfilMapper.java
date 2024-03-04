package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface PerfilMapper {
	PerfilDTO perfilToDTO(Perfil perfil);
	
	List<PerfilDTO> listPerfiltoListDTO(List<Perfil> perfis); 
	
	Perfil DTOToPerfil(PerfilDTO perfilDTO);
}
