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
	@JoinTable(name = "refeicao_has_alimento" , 
		joinColumns = @JoinColumn(name = "alimento_idAlimento"),
		inverseJoinColumns = @JoinColumn(name = "refeicao_idRefeicao"))
	@Getter @Setter
	private List<Refeicao> refeicoes;
}
