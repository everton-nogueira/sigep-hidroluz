package br.com.webfitness.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Amizade {
	@Id
	@Getter @Setter
	private Integer idAmizade;
	
	@Getter @Setter
	private Integer statusAmizade;

	@ManyToOne
	@JoinColumn(name="pessoa_idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="pessoa_idAmigo")
	@Getter @Setter
	private Pessoa amigo;
}
