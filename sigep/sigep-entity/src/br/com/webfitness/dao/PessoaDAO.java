/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webfitness.dao.generic.Dao;
import br.com.webfitness.entidades.Pessoa;


/**
 * @author Everton
 * Data: 23/02/2015
 */
public class PessoaDAO implements Dao<Pessoa> {

	@Inject
	EntityManager em;

	@Override
	public void salvar(Pessoa poco) {
		em.getTransaction().begin();
		em.persist(poco);
		em.getTransaction().commit();
	}

	@Override
	public Pessoa alterar(Pessoa poco) {
		em.getTransaction().begin();
		Pessoa alterado = em.merge(poco);
		em.getTransaction().commit();
		return alterado;
	}

	@Override
	public void excluir(Pessoa poco) {
		em.getTransaction().begin();
		em.remove(poco);
		em.getTransaction().commit();
	}

	@Override
	public Pessoa buscar(Pessoa poco) {
		return em.find(Pessoa.class, poco);
	}

	@Override
	public List<Pessoa> listar() {
		TypedQuery<Pessoa> query = em.createNamedQuery("selectAll", Pessoa.class);
		return query.getResultList(); 
	}
	
}
