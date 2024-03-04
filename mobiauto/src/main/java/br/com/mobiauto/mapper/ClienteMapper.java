package br.com.mobiauto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mobiauto.dto.ClienteDTO;
import br.com.mobiauto.model.Cliente;

//Utilização do MapStruct para mapeamento automatizado e diminuição do código.
@Mapper(componentModel = "spring")
public interface ClienteMapper {
	ClienteDTO clienteToDTO(Cliente cliente);
	
	List<ClienteDTO> listClientetoListDTO(List<Cliente> cliente); 
	
	@Mapping(target = "id", ignore = true)
	Cliente DTOToCliente(ClienteDTO clienteDTO);
}
