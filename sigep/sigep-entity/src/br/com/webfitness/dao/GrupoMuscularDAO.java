/**
 * Desenvolvido por Éverton Nogueira em 20/09/2016
 */
package br.com.webfitness.dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.webfitness.dao.generic.DaoImpl;
import br.com.webfitness.entidades.GrupoMuscular;

/**
 * @author Éverton Nogueira
 * @Data 20/09/2016
 *
 */
public class GrupoMuscularDAO extends DaoImpl<GrupoMuscular> {
	public GrupoMuscular findGrupoMuscularByNome(String nome) {
		Query query = em.createQuery("SELECT gm FROM GrupoMuscular gm WHERE gm.nome = :nome");
		query.setParameter("nome", nome);
		GrupoMuscular grupo = null;
		try{
			grupo = (GrupoMuscular) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e){
			//Não tem o que tratar..
		}
		return grupo; 
	}
}
