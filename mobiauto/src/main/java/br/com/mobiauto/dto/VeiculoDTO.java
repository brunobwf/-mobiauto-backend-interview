package br.com.mobiauto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VeiculoDTO {
		
	private String marca;

	private String modelo;
		
	private String versao;
	
	private int ano;
	
}
