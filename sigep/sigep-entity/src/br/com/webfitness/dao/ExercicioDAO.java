/**
 * Desenvolvido por Éverton Nogueira em 20/09/2016
 */
package br.com.webfitness.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.webfitness.dao.generic.DaoImpl;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.GrupoMuscular;

/**
 * @author Éverton Nogueira
 * @Data 20/09/2016
 *
 */
public class ExercicioDAO extends DaoImpl<GrupoMuscular> {
	@SuppressWarnings("unchecked")
	public List<Exercicio> findExercicioByGrupoMuscular(GrupoMuscular grupo) {
		Query query = em.createNamedQuery("selectByGrupoMuscular", Exercicio.class);
		query.setParameter("grpMuscular", grupo);
		return query.getResultList(); 
	}
}
