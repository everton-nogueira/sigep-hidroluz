/**
 * Desenvolvido por Everton e z 23/02/2015
 */
package br.com.webfitness.fabrica;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * @author Everton
 * Data: 23/02/2015
 */
public class FactoryEntityManager {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_WEBFITNESS"); 
	
	@Produces
	@RequestScoped
	@PersistenceContext
	public EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public void destroyEntityManager(@Disposes EntityManager em){
		em.close();
	}
}
