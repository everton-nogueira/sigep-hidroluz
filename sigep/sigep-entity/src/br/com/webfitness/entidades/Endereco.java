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
public class Endereco {
	@Id
	@Getter @Setter
	private Integer idEndereco;
	
	@Getter @Setter
	private String estado;
	
	@Getter @Setter
	private String cidade;
	
	@Getter @Setter
	private String pais;
	
	@Getter @Setter
	private String endereco;
	
	@Getter @Setter
	private String pontoReferencia;
	
	@OneToMany(mappedBy="endereco")
	@JoinColumn(name="idEndereco")
	@Getter @Setter
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="endereco")
	@JoinColumn(name="idEndereco")
	@Getter @Setter
	private Academia academia;
}
