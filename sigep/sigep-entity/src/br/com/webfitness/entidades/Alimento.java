package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Alimento {
	@Getter @Setter
	@Id
	private Integer idAlimento;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private Integer quantidade;

}
