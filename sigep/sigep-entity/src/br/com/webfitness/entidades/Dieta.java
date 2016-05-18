/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class Dieta {
	@Id
	@Getter @Setter
	private Integer idDieta;
	
	@Getter @Setter
	private Integer qtdRefeicoes;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	@Getter @Setter
	private Pessoa pessoa;

	@ManyToMany(mappedBy="dietas")
	@Getter @Setter
	private List<Alimento> alimentos;
	
}
