package br.com.webfitness.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@Getter @Setter
	private Date dataVideo;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_idpessoa")
	@Getter @Setter
	private Pessoa pessoa;

	@ManyToMany(mappedBy = "videos")
	@Getter @Setter
	private List<Postagem> postagens;
}
