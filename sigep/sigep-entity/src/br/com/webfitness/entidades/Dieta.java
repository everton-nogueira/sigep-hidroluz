/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.Date;
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
public class Dieta {
	@Id
	@Getter @Setter
	private Integer idDieta;
	
	@Getter @Setter
	private Date dataInicio;
	
	@Getter @Setter
	private Date dataFim;
	
	@Getter @Setter
	private String objetivo;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@OneToMany(mappedBy ="dieta")
	@Getter @Setter
	private List<Refeicao> refeicoes;
	
}
