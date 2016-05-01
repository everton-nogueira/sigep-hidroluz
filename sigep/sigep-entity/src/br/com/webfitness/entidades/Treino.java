/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class Treino {

	@Id
	@Getter @Setter
	private Integer idTreino;
	
	@Getter @Setter
	private String nome;
	
	@ManyToOne
	@Getter @Setter
	private Pessoa pessoa;
	
	@ManyToMany (mappedBy = "treinos")
	@Getter @Setter
	private List<Exercicio> exercicios;
}
