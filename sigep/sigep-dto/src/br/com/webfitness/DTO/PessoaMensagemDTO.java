/**
 * Desenvolvido por Everton 19/07/2016
 */
package br.com.webfitness.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 19/07/2016
 */
@Getter @Setter
public class PessoaMensagemDTO {
	private PessoaDTO pessoaOrigem;
	private PessoaDTO pessoaDestino;
	private MensagemDTO mensagem;
}
