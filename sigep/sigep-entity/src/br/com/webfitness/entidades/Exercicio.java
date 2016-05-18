/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class Exercicio {

	@Id
	@Getter @Setter
	private Integer idExercicio;
	
	@Getter @Setter
	private Integer qtdSeries;
	
	@Getter @Setter
	private Integer qtdRepeticoes;
	
	@Getter @Setter
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "idGrupoMuscular")
	@Getter @Setter
	private GrupoMuscular grupoMuscular;
	
	@ManyToMany
	@JoinTable(name = "treinoExercicio" , 
		joinColumns = @JoinColumn(name = "idExercicio"),
		inverseJoinColumns = @JoinColumn(name = "idTreino"))
	@Getter @Setter
	private List<Treino> treinos;
	
}
