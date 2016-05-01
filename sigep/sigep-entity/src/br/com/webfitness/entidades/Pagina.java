package br.com.webfitness.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
@Entity
public class Pagina {
	@Id
	@Getter @Setter
	private Integer idPagina;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private Date dataCriacao;
	
	@ManyToOne
	@Getter @Setter
	private Pessoa pessoa;
}
