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
public class CategoriaSuplemento {
	@Id
	@Getter @Setter
	private Integer idCategoriaSuplemento;
	
	@Getter @Setter
	private String nomeCategoria;
	
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "categoriaSuplemento")
	@Getter @Setter
	private List<Suplemento> suplementos;
}
