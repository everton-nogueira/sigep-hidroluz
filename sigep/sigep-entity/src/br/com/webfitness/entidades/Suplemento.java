package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name ="categoriaSuplemento_idCategoriaSuplemento")
	@Getter @Setter
	private CategoriaSuplemento categoria;
	
	@ManyToMany
	@JoinTable(name = "refeicao_has_suplemento" , 
		joinColumns = @JoinColumn(name = "suplemento_idSuplemento"),
		inverseJoinColumns = @JoinColumn(name = "refeicao_idRefeicao"))
	@Getter @Setter
	private List<Refeicao> refeicoes;

	
}
