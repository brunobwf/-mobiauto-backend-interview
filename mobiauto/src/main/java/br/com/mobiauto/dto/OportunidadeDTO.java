package br.com.mobiauto.dto;


import java.time.LocalDate;


import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OportunidadeDTO {
	
	private Long id;
	private UsuarioResponsavelDTO  usuario;
	private Status status;
	private Cliente cliente;
	private Veiculo veiculo;
	private String motivoConclusao;
	private LocalDate dataAtrib;
	private LocalDate dataConclusao;
}
