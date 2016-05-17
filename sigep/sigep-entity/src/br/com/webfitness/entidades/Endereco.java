/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@OneToMany(targetEntity = Pessoa.class, mappedBy="endereco")
	@Getter @Setter
	private List<Pessoa> pessoa;
	
	@OneToMany(targetEntity = Academia.class, mappedBy="endereco")
	@Getter @Setter
	private List<Academia> academia;
}
