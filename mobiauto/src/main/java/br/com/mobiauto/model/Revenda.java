package br.com.mobiauto.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "revendas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Revenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//Utilizando por padrão de 14 caracteres máximos de um CNPJ sem os caracteres de ponto e barra.
	@Column(name = "cnpj_revenda", length=14, nullable = false)
	private String cnpjRevenda;
	
	@Column(name = "nome_social", length=150, nullable = false)
	private String nomeSocial;
}
