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
	 * @Descri��o: M�todo respons�vel por realizar a persist�ncia das informa��es no banco de dados. 
	 */
	void salvar(ENTIDADE entidade);
	/**
	 * @Descri��o: M�todo respons�vel por realizar altera��es das informa��es no banco de dados. 
	 */
	ENTIDADE alterar(ENTIDADE entidade);
	/**
	 * @Descri��o: M�todo respons�vel por remover as informa��es no banco de dados. 
	 */
	void excluir(ENTIDADE entidade);
	/**
	 * @Descri��o: M�todo respons�vel por realizar uma busca simples de informa��es no banco de dados. 
	 */
	ENTIDADE buscar(ENTIDADE entidade, Class<ENTIDADE> classe);
	/**
	 * @Descri��o: M�todo respons�vel por realizar uma listagem de informa��es no banco de dados. 
	 */
	List<ENTIDADE> listar(Class<ENTIDADE> classe);
}
