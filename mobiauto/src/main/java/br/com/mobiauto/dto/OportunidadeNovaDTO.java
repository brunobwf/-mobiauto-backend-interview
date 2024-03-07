package br.com.mobiauto.dto;


import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OportunidadeNovaDTO {

	private Long  idUsuarioResponsavel;
	private Cliente cliente;
	private Veiculo veiculo;
}
