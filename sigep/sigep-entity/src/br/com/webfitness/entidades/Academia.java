/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private Telefone telefone;
	@Getter @Setter
	private Endereco endereco;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String valor;
	@Getter @Setter
	private Integer nivel;
	@Getter @Setter
	private String horarioFuncionamento;
	
	
	
}
