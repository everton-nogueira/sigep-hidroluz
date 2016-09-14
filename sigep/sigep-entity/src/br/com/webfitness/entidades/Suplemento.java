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
public class Suplemento {
	@Id
	@Getter @Setter
	private Integer idSuplemento;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String marca;
	
	@Getter @Setter
	private float valor;
	
	@ManyToOne
	@JoinColumn(name = "idCategoriaSuplemento")
	@Getter @Setter
	private CategoriaSuplemento categoriaSuplemento;
	
}
