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

@Table(name = "clientes")
@Entity(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 150, nullable = false)
	private String email;
	
	@Column(length = 150, nullable = false)
	private String telefone;
	
}
