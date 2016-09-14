/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class Treino implements Comparable<Treino>{

	@Id
	@Getter @Setter
	private Integer idTreino;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private Date dataInicio;
	
	@Getter @Setter
	private Date dataFim;
	
	@Getter @Setter
	private Integer objetivo;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@ManyToMany (mappedBy = "treinos")
	@Getter @Setter
	private List<Exercicio> exercicios;

	@Override
	public int compareTo(Treino o) {
		return this.dataInicio.compareTo(o.getDataInicio());
	}
	
}