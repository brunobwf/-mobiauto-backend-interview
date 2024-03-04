package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Usuario;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	UsuarioDTO usuarioToDTO(Usuario usuario);
	
	List<UsuarioResponseDTO> listUsuariosToResponse(List<Usuario> usuarios);
	
	UsuarioResponseDTO usuarioToResponse(Usuario usuario);
	
	@Mapping(target = "id", ignore = true)
	Usuario dTOToUsuario(UsuarioDTO usuarioDTO);
}
