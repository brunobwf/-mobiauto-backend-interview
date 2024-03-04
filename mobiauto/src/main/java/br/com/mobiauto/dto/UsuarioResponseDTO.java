package br.com.mobiauto.dto;

import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class UsuarioResponseDTO {
	
	private Long id;
	
	private String nome;
	
	private String email;

	private Perfil perfil;
	
	private Revenda revenda;


}
