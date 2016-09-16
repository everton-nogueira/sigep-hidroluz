/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private String nome;
	
	@Getter @Setter
	private Integer nivelDificuldade;
	
	@Getter @Setter
	private String imagem;
	
	@Getter @Setter
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "grupoMuscular_idGrupoMuscular")
	@Getter @Setter
	private GrupoMuscular grupoMuscular;
	
	@OneToMany(mappedBy = "exercicio")
	@Getter @Setter
	private List<TreinoExercicio> treinosDoExercicio;
	
}
