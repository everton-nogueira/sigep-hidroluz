/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
@NoArgsConstructor
public class GrupoMuscular {
	
	@Id
	@Getter @Setter
	private Integer idGrupoMuscular;
	
	public GrupoMuscular(String nome) {
		this.nome = nome;
	}

	@Getter @Setter
	private String nome;
	
	@OneToMany(targetEntity = Exercicio.class, mappedBy = "grupoMuscular")
	@Getter @Setter
	private List<Exercicio> exercicios;
}
