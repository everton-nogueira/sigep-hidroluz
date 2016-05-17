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
public class Telefone {
	@Id
	@Getter @Setter
	private Integer idTelefone;
	
	@Getter @Setter
	private Integer numero;
	
	@Getter @Setter
	private Integer ddd;
	
	@OneToMany(mappedBy="telefone")
	@Getter @Setter
	private List<Pessoa> pessoa;
	
	@OneToMany(mappedBy="telefone")
	@Getter @Setter
	private List<Academia> academia;
}
