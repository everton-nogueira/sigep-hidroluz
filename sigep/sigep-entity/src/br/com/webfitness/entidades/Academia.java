/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 27/04/2016
 */
@Entity
public class Academia {
	
	@Getter @Setter
	@Id
	private Integer idAcademia;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String valor;
	@Getter @Setter
	private Integer nivel;
	@Getter @Setter
	private String horarioFuncionamento;
	
	@OneToMany(targetEntity = Pessoa.class, mappedBy="academia")
	@Getter @Setter
	private List<Pessoa> pessoa;
	
	@ManyToOne
	@Getter @Setter
	private Endereco endereco;
	
	@ManyToOne
	@Getter @Setter
	private Telefone telefone;
	
}
