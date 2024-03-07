package br.com.mobiauto.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.mobiauto.model.Oportunidade;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RevendaDTO {

	private String cnpjRevenda;

	@NotBlank(message = "Social Name is mandatory")
	private String nomeSocial;

	private List<OportunidadeRevendaDTO> oportunidades;

	public RevendaDTO(String cnpjRevenda, String nomeSocial, List<Oportunidade> oportunidadesEntity,
			List<OportunidadeRevendaDTO> oportunidadesDTO) {
		if (oportunidadesEntity != null) {
			oportunidades = new ArrayList<OportunidadeRevendaDTO>();
			for (Oportunidade oportunidade : oportunidadesEntity) {
				this.oportunidades.add(new OportunidadeRevendaDTO(oportunidade.getId()));
			}
		}
		this.cnpjRevenda = cnpjRevenda;
		this.nomeSocial = nomeSocial;
	}

}
