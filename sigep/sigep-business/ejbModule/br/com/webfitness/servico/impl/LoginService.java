/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.servico.impl;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.servico.LoginServiceLocal;

/**
 * @author Everton
 * Data: 12/05/2016
 */
//@Stateless
public class LoginService implements LoginServiceLocal {

//	@Inject
//	private PessoaDAO pessoaDao;
//	
//	private PessoaAdapter adapter = new PessoaAdapter();
//	
	@Override
	public PessoaDTO realizaLogin(String login, String senha) {
		PessoaDTO pessoa = null;// = adapter.getDTO(pessoaDao.buscar(login));
		return pessoa;
	}

}
