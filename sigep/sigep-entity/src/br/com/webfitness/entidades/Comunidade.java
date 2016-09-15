package br.com.webfitness.entidades;

import java.util.Date;
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
public class Comunidade {
	@Id
	@Getter @Setter
	private Integer idComunidade;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private Date dataCriacao;
	
	@ManyToMany
	@JoinTable(name = "pessoa_has_comunidade" , 
	joinColumns = @JoinColumn(name = "comunidade_idComunidade"),
	inverseJoinColumns = @JoinColumn(name = "pessoa_idPessoa"))
	@Getter @Setter
	private List<Pessoa> pessoas;
}
