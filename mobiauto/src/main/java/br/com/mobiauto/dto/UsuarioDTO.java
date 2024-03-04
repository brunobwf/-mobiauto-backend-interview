package br.com.mobiauto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UsuarioDTO {
	
	@NotBlank(message = "Name is mandatory")
	private String nome;
	
	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotBlank(message = "Password is mandatory")
	private String senha;
	
	@NotNull(message = "Perfil is mandatory")
	private Long idPerfil;
	
	private Long idRevenda;


}
