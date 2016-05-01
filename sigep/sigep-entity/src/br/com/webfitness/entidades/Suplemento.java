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
	@Getter @Setter
	private CategoriaSuplemento categoriaSuplemento;
	
	@ManyToMany
	@JoinTable(name = "suplementoPessoa" , 
		joinColumns = @JoinColumn(name = "idSuplemento"),
		inverseJoinColumns = @JoinColumn(name = "idPessoa"))
	@Getter @Setter
	private List<Pessoa> pessoas;
	
}
