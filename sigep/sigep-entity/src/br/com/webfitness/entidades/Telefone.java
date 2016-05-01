/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 27/04/2016
 */
@Entity
public class Telefone {
	@Id
	@Getter @Setter
	private Integer idTelefone;
	
	@Getter @Setter
	private Integer numero;
	
	@Getter @Setter
	private Integer ddd;
	
	@OneToMany(mappedBy="telefone")
	@JoinColumn(name="idTelefone")
	@Getter @Setter
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="telefone")
	@JoinColumn(name="idTelefone")
	@Getter @Setter
	private Academia academia;
}
