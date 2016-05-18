package br.com.webfitness.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Video {
	@Id
	@Getter @Setter
	private Integer idVideo;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
}
