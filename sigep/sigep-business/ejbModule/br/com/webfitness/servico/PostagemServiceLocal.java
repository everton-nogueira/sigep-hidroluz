/**
 * 
 */
package br.com.webfitness.servico;

import java.util.List;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Postagem;

/**
 * @author Belgrano
 * @Data: 23/09/2016
 */
public interface PostagemServiceLocal {
	
	/**
	 * @Descrição Busca ultimas postagens depois definir qual vai ser a relevacia 
	 * @Parametros PostagemServiceLocal
	 * @Retorno List<Postagem>
	 * @return
	 */
	List<Postagem> buscaUltimasPostagensPorRelevancia();

	/**
	 * @Descrição 
	 * @Parametros PostagemServiceLocal
	 * @Retorno void
	 * @param texto
	 * @param pessoaDTO 
	 */
	void realizaPostagem(String texto, PessoaDTO pessoaDTO);
	
}
