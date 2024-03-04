package br.com.mobiauto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class ClienteDTO {
	
	private String nome;

	private String email;
	
	private String telefone;
	
}
