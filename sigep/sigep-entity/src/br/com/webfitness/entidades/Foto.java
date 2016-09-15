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
public class Foto {
	@Id
	@Getter @Setter
	private Integer idFoto;
	
	@Getter @Setter
	private String localizacao;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private Date dataFoto;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@ManyToMany(mappedBy = "fotos")
	@Getter @Setter
	private List<Postagem> postagens;
}
