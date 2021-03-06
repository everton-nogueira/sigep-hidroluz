/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.dao.generic;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public abstract class DaoImpl<ENTIDADE> implements Dao<ENTIDADE> {
	
	//Criar uma namedQuery na entidade desejada com o nome da classe e o nome definido nessa constante separado por um ponto. (Ex: Named Query na classe Pessoa deve ser "Pessoa.selectAll").
	private static final String SELECT_ALL = "selectAll";
	
	@Inject
	protected EntityManager em;
	
	@Override
	public void salvar(ENTIDADE entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@Override
	public ENTIDADE alterar(ENTIDADE entidade) {
		em.getTransaction().begin();
		ENTIDADE alterada = em.merge(entidade);
		em.getTransaction().commit();
		return alterada;
	}

	@Override
	public void excluir(ENTIDADE entidade) {
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}

	@Override
	public ENTIDADE buscar(Object id, Class<ENTIDADE> classe) {
		return em.find(classe, id);
	}

	@Override
	public List<ENTIDADE> listar(Class<ENTIDADE> classe) {
		TypedQuery<ENTIDADE> query = em.createNamedQuery(classe.getSimpleName()+"."+SELECT_ALL, classe);
		return query.getResultList(); 
	}

}
