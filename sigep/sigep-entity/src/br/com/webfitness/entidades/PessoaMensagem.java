/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class PessoaMensagem implements Serializable{
	private static final long serialVersionUID = 8655605307491069252L;

	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idPessoaOrigem")
	private Pessoa pessoaOrigem;
	
	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idPessoaDestino")
	private Pessoa pessoaDestino;
	
	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idMensagem")
	private Mensagem mensagem;
	
}
