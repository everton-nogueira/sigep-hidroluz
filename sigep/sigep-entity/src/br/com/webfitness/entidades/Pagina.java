package br.com.webfitness.entidades;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
public class Pagina {
	@Getter @Setter
	@Id
	private Integer idPagina;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private Date dataCriacao;
	@ManyToOne
	private Pessoa pessoa;
}
