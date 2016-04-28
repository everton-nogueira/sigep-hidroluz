package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class CategoriaSuplemento {
	@Getter @Setter
	@Id
	private Integer idCategoriaSuplemento;
	@Getter @Setter
	private String nomeCategoria;
	@ManyToOne
	private Suplemento suplemento;
}
