/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.servico;

import br.com.webfitness.DTO.PessoaDTO;


/**
 * @author Everton
 * Data: 12/05/2016
 */
public interface LoginServiceLocal {
	PessoaDTO realizaLogin(String login, String senha);
}
