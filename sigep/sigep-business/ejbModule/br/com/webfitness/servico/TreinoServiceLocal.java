/**
 * Desenvolvido por Éverton Nogueira em 16/09/2016
 */
package br.com.webfitness.servico;

import java.util.List;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.GrupoMuscular;
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
	/**
	 * @Autor Éverton Nogueira
	 * @Description Método que retorna um grupo muscular pelo nome informado 
	 * @param valor
	 * @return Grupo Muscular
	 */
	GrupoMuscular getGrupoMuscularByNome(String valor);
	/**
	 * @Autor Éverton Nogueira
	 * @Description  Método que retorna todos os grupos musculares da base de dados.
	 * @return Lista de Grupo Muscular
	 */
	List<GrupoMuscular> findAllGrupoMuscular();
	/**
	 * @Autor Éverton Nogueira
	 * @Description Busca uma lista de exercícios para um grupo muscular específico
	 * @param grupoMuscular
	 * @return
	 */
	List<Exercicio> findExercicioByGrupoMuscular(GrupoMuscular grupoMuscular);
}
