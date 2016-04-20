/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webfitness.entidades.Poco;


/**
 * @author Everton
 * Data: 23/02/2015
 */
public class PocoDAO implements Dao<Poco> {

	@Inject
	EntityManager em;

	@Override
	public void salvar(Poco poco) {
		em.getTransaction().begin();
		em.persist(poco);
		em.getTransaction().commit();
	}

	@Override
	public Poco alterar(Poco poco) {
		em.getTransaction().begin();
		Poco alterado = em.merge(poco);
		em.getTransaction().commit();
		return alterado;
	}

	@Override
	public void excluir(Poco poco) {
		em.getTransaction().begin();
		em.remove(poco);
		em.getTransaction().commit();
	}

	@Override
	public Poco buscar(Poco poco) {
		return em.find(Poco.class, poco);
	}

	@Override
	public List<Poco> listar() {
		TypedQuery<Poco> query = em.createNamedQuery("selectAll", Poco.class);
		return query.getResultList(); 
	}
	
}
