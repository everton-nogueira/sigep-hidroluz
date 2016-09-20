/**
 * Desenvolvido por Éverton Nogueira em 16/09/2016
 */
package br.com.webfitness.servico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.dao.ExercicioDAO;
import br.com.webfitness.dao.GrupoMuscularDAO;
import br.com.webfitness.dao.TreinoDAO;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.GrupoMuscular;
import br.com.webfitness.entidades.Treino;
import br.com.webfitness.servico.TreinoServiceLocal;

/**
 * @author Éverton Nogueiraãã
 * @Data 16/09/2016
 *
 */
@Stateless
public class TreinoService implements TreinoServiceLocal{
	
	@Inject
	private TreinoDAO treinoDAO;
	
	@Inject 
	private GrupoMuscularDAO grupoMuscularDAO;
	
	@Inject
	private ExercicioDAO exercicioDAO;
	
	private PessoaAdapter adapter = new PessoaAdapter();
	
	@Override
	public List<Treino> getTreinoAtual(PessoaDTO pessoa) {
		return treinoDAO.findTreinoAtual(adapter.getEntidade(pessoa));
	}

	@Override
	public GrupoMuscular getGrupoMuscularByNome(String nome) {
		return grupoMuscularDAO.findGrupoMuscularByNome(nome);
	}

	@Override
	public List<GrupoMuscular> findAllGrupoMuscular() {
		return grupoMuscularDAO.listar(GrupoMuscular.class);
	}

	@Override
	public List<Exercicio> findExercicioByGrupoMuscular(GrupoMuscular grupoMuscular) {
		if(grupoMuscular == null || grupoMuscular.getIdGrupoMuscular() == null){
			grupoMuscular = grupoMuscularDAO.findGrupoMuscularByNome(grupoMuscular.getNome());
		}
		return exercicioDAO.findExercicioByGrupoMuscular(grupoMuscular);
	}

}
