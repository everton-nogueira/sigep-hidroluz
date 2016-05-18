/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.servico.impl;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.dao.PessoaDAO;
import br.com.webfitness.dominio.AtributoHttpRequest;
import br.com.webfitness.servico.LoginServiceLocal;

/**
 * @author Everton Data: 12/05/2016
 */
@Stateless
public class LoginService implements LoginServiceLocal {

	@Inject
	private PessoaDAO pessoaDao;

	private PessoaAdapter adapter = new PessoaAdapter();

	@Override
	public PessoaDTO realizaLogin(String login, String senha) {
		PessoaDTO pessoa = adapter.getDTO(pessoaDao.buscar(login));
		if (pessoa != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			try {
				if (request.getRemoteUser() != null) {
					request.logout();
				}
			} catch (ServletException e) {
				System.out.println("Erro ao efetuar o logout do usuário: " + e.getMessage());
			}
			realizaLoginJaas(login, senha, request);
		}
		return pessoa;
	}
	
	@Override
	public void realizaLogout() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			((HttpServletRequest) facesContext.getExternalContext().getRequest()).logout();
			facesContext.getExternalContext().invalidateSession();
		} catch (ServletException e) {
			System.out.println("Erro ao efetuar o logout do usuário: " + e.getMessage());
		}
	}

	private void realizaLoginJaas(String login, String senha, HttpServletRequest request) {
		request.setAttribute(AtributoHttpRequest.ATRIBUTO_LOGIN.getValor(), login);
		request.setAttribute(AtributoHttpRequest.ATRIBUTO_SENHA.getValor(), senha);
		try {
			request.login(login, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
