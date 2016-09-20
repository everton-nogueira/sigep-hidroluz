/**
 * Desenvolvido por Éverton Nogueira em 16/09/2016
 */
package br.com.webfitness.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.webfitness.dao.generic.DaoImpl;
import br.com.webfitness.entidades.Pessoa;
import br.com.webfitness.entidades.Treino;

/**
 * @author Éverton Nogueira
 * @Data 16/09/2016
 *
 */
public class TreinoDAO extends DaoImpl<Treino>{

	@SuppressWarnings("unchecked")
	public List<Treino> findTreinoAtual(Pessoa pessoa) {
		Query query = em.createNamedQuery("selectTreinoAtual", Treino.class);
		query.setParameter("pessoa", pessoa);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}
