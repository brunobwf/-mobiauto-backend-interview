package br.com.mobiauto.model;


import java.util.List;

import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "revendas")
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
	
	@OneToMany
	@JoinColumn(name = "id_oportunidade" )
	private List<Oportunidade> oportunidades;
}
