/**
 * 
 */
package br.com.webfitness.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 *
 */
@Entity
@Table(name = "treino_has_exercicio")
@EqualsAndHashCode
public class TreinoExercicio implements Serializable{
	private static final long serialVersionUID = -3933728985266874935L;

	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "treino_idTreino")
	private Treino treino;
	
	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "exercicio_idExercicio")
	private Exercicio exercicio;
	
	@Getter @Setter
	private Integer qtdSeries;
	
	@Getter @Setter
	private Integer qtdRepeticoes;
	
	@Getter @Setter
	private String observacao;
}
