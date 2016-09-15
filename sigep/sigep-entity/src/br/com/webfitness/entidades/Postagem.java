/**
 * 
 */
package br.com.webfitness.entidades;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @Autor Belgrano
 * @Data:  14/09/2016
 */
public class Postagem {

	@Id
	@Getter @Setter
	private Integer idPostagem;
	
	@Getter @Setter
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@Getter @Setter
	private Pessoa pessoa; 
	
}
