/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.servico.impl;

import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.dao.PessoaDAO;
import br.com.webfitness.servico.LoginServiceLocal;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public class LoginService implements LoginServiceLocal {

	@Inject
	private PessoaDAO pessoaDao;
	
	@Inject
	private PessoaAdapter adapter;
	
	@Override
	public PessoaDTO realizaLogin(String login, String senha) {
		PessoaDTO pessoa = adapter.getDTO(pessoaDao.buscar(login));
		return null;
	}

}
