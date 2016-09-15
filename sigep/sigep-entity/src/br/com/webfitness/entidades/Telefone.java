/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 27/04/2016
 */
@Entity
public class Telefone {
	@Id
	@Getter @Setter
	private Integer idTelefone;
	
	@Getter @Setter
	private Integer numero;
	
	@Getter @Setter
	private Integer ddd;
	
	@Getter @Setter
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "pessoa_has_telefone" , 
		joinColumns = @JoinColumn(name = "telefone_idTelefone"),
		inverseJoinColumns = @JoinColumn(name = "pessoa_idPessoa"))
	@Getter @Setter
	private List<Pessoa> pessoas;
	
	@ManyToMany
	@JoinTable(name = "academia_has_telefone" , 
	joinColumns = @JoinColumn(name = "telefone_idTelefone"),
		inverseJoinColumns = @JoinColumn(name = "academia_idAcademia"))
	@Getter @Setter
	private List<Academia> academias;
}
