package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Alimento {
	@Id
	@Getter @Setter
	private Integer idAlimento;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private Integer quantidade;
	
	@ManyToMany
	@JoinTable(name = "dietaAlimento" , 
		joinColumns = @JoinColumn(name = "idAlimento"),
		inverseJoinColumns = @JoinColumn(name = "idDieta"))
	@Getter @Setter
	private List<Dieta> dietas;
}
