package br.com.mobiauto.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OportunidadeRequestUpdateDTO {
	private Long  idUsuarioResponsavel;
	private Long  status;
	private String motivoConclusao;
}
