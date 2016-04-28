package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Suplemento {
	@Getter @Setter
	@Id
	private Integer idSuplemento;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String marca;
	@Getter @Setter
	private float valor;	
	@Getter @Setter
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "suplemento")
	private List<CategoriaSuplemento> categoriaSuplemento;
}
