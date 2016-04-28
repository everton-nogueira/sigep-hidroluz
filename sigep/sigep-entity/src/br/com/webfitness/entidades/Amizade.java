package br.com.webfitness.entidades;


import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
public class Amizade {
	@Getter @Setter
	@Id
	private Integer idAmizade;
	@Getter @Setter
	private Integer statusAmizade;
	@ManyToOne
	private Pessoa pessoa;
}
