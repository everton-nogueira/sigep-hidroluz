/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.dao;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.webfitness.dao.generic.DaoImpl;
import br.com.webfitness.entidades.Pessoa;

/**
 * @author Everton
 * Data: 23/02/2015
 */
@Named
public class PessoaDAO extends DaoImpl<Pessoa> {
	
	public Pessoa buscar(String email) {
		TypedQuery<Pessoa> query = em.createNamedQuery("selectLogin", Pessoa.class);
		query.setParameter("email", email);
		return query.getSingleResult(); 
	}
	
}
