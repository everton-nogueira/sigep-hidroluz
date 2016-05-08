/**
 * Desenvolvido por Everton 07/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 07/05/2016
 */
@Entity
public class Funcao {

	@Id
	@Getter @Setter
	private Integer idFuncao;
	
	@Getter @Setter
	private String nome;
	
	@ManyToMany(mappedBy="funcoes")
	@Getter @Setter
	private List<Pessoa> pessoas;
}
