package br.com.mobiauto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RevendaDTO {
	
	private String cnpjRevenda;
	
	@NotBlank(message = "Social Name is mandatory")
	private String nomeSocial;
}
