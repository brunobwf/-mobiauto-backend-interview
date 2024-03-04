package br.com.mobiauto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "veiculos")
@Entity(name = "veiculos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(length = 150, nullable = false)
	private String marca;
	
	@Column(length = 150, nullable = false)
	private String modelo;
	
	@Column(length = 150, nullable = false)
	private String versao;
	
	@Column(length = 150, nullable = false)
	private int ano;
	
}
