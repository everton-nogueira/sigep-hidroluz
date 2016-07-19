/**
 * Desenvolvido por Everton 19/07/2016
 */
package br.com.webfitness.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 19/07/2016
 */
public class MensagemDTO {
	@Getter @Setter
	private String mensagem;
	@Getter @Setter
	private Date data;
	@Getter @Setter
	private PessoaDTO pessoa;
}
