/**
 * 
 */
package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @Autor Belgrano
 * @Data:  14/09/2016
 */
@Entity
public class Postagem {

	@Id
	@Getter @Setter
	private Integer idPostagem;
	
	@Getter @Setter
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
}
