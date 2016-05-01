package br.com.webfitness.entidades;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
public class Video {
	@Id
	@Getter @Setter
	private Integer idVideo;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private String link;
	
	@ManyToOne
	@Getter @Setter
	private Pessoa pessoa;
}
