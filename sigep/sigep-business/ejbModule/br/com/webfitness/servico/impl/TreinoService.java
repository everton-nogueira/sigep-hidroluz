/**
 * Desenvolvido por Éverton Nogueira em 16/09/2016
 */
package br.com.webfitness.servico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.dao.generic.TreinoDAO;
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
	
	private PessoaAdapter adapter = new PessoaAdapter();
	
	@Override
	public List<Treino> getTreinoAtual(PessoaDTO pessoa) {
		return treinoDAO.findTreinoAtual(adapter.getEntidade(pessoa));
	}

}
