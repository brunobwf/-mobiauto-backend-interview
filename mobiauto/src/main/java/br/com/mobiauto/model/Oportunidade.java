package br.com.mobiauto.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "oportunidades")
@Entity(name = "oportunidades")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Oportunidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_status", nullable = false)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_veiculo", nullable = false)
	private Veiculo veiculo;
	
	@Column(name = "motivo_conclusao",length = 500)
	private String motivoConclusao;
	
	@Column(name = "data_atribuicao")
	private LocalDate dataAtrib;
	
	@Column(name = "data_conclusao")
	private LocalDate dataConclusao;
	
}
