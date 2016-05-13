/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.dao.generic;

import java.util.List;

/**
 * @author Everton
 * Data: 23/02/2015
 */
public interface Dao <ENTIDADE> {
	/**
	 * @Descrição: Método responsável por realizar a persistência das informações no banco de dados. 
	 */
	void salvar(ENTIDADE entidade);
	/**
	 * @Descrição: Método responsável por realizar alterações das informações no banco de dados. 
	 */
	ENTIDADE alterar(ENTIDADE entidade);
	/**
	 * @Descrição: Método responsável por remover as informações no banco de dados. 
	 */
	void excluir(ENTIDADE entidade);
	/**
	 * @Descrição: Método responsável por realizar uma busca simples de informações no banco de dados. 
	 */
	ENTIDADE buscar(ENTIDADE entidade, Class<ENTIDADE> classe);
	/**
	 * @Descrição: Método responsável por realizar uma listagem de informações no banco de dados. 
	 */
	List<ENTIDADE> listar(Class<ENTIDADE> classe);
}
