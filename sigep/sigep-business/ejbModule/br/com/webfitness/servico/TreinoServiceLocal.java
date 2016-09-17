/**
 * Desenvolvido por Éverton Nogueira em 16/09/2016
 */
package br.com.webfitness.servico;

import java.util.List;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Treino;

/**
 * @author Éverton Nogueira
 * @Data 16/09/2016
 *
 */
public interface TreinoServiceLocal {
	
	/**
	 * @Autor Éverton Nogueira
	 * @Description Método responsável por buscar os treinos atuais de uma pessoa. 
	 * @param pessoa
	 * @return Lista de treinos
	 */
	List<Treino> getTreinoAtual(PessoaDTO pessoa);
}
