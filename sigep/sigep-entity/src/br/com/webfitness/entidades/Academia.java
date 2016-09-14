/**
 * Desenvolvido por Everton 27/04/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 27/04/2016
 */
@Entity
public class Academia {
	
	@Getter @Setter
	@Id
	private Integer idAcademia;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String valor;
	@Getter @Setter
	private Integer nivel;
	@Getter @Setter
	private String horarioFuncionamento;
	
	@OneToMany(targetEntity = Pessoa.class, mappedBy="academia")
	@Getter @Setter
	private List<Pessoa> pessoa;
	
	@ManyToOne
	@JoinColumn(name = "endereco_idEndereco")
	@Getter @Setter
	private Endereco endereco;
	
	@ManyToMany(mappedBy = "academias")
	@Getter @Setter
	private List<Telefone> telefones;
	
}
