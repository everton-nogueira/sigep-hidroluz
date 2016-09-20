/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
@NamedQueries(value = { @NamedQuery(name="selectTreinoAtual", query="SELECT t FROM Treino t WHERE t.pessoa = :pessoa AND :dataAtual between t.dataInicio AND t.dataFim") } )
public class Treino implements Comparable<Treino> , Serializable{
	private static final long serialVersionUID = -8806803445359483677L;

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
	@JoinColumn(name ="pessoa_idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "treino")
	@Getter @Setter
	private List<TreinoExercicio> exerciciosDoTreino;

	@Override
	public int compareTo(Treino o) {
		return this.nome.compareTo(o.getNome());
	}
	
}