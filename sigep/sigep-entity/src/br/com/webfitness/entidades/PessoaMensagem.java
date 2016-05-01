/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class PessoaMensagem {
	@Id
	@Getter @Setter
	@JoinColumn(name = "idPessoaOrigem")
	private Pessoa pessoaOrigem;
	
	@Id
	@Getter @Setter
	@Column(name = "idPessoaDestino")
	private Pessoa pessoaDestino;
	
	@Id
	@Getter @Setter
	@JoinColumn(name = "idMensagem")
	private Mensagem mensagem;
	
}
