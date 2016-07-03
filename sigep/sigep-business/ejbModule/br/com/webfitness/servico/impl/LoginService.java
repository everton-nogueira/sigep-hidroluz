/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.servico.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.constante.ConstantesWebFitness;
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
	
	@Getter @Setter
	private Map<String, PessoaDTO> mapaSessaoPessoa = new HashMap<String, PessoaDTO>();
	
	@Override
	public PessoaDTO realizaLogin(String login, String senha) throws Exception {
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
			adicionaPessoaNaSessao(pessoa, facesContext);
		}
		return pessoa;
	}
	
	private void adicionaPessoaNaSessao(PessoaDTO pessoa, FacesContext facesContext) {
		//Obtém a sessão atual ou cria uma nova
		HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object usuario = httpSession.getAttribute(ConstantesWebFitness.LOGIN_USER.getValor());
		if(usuario == null){
			mapaSessaoPessoa.put(pessoa.getEmail(), pessoa);
			httpSession.setAttribute(ConstantesWebFitness.LOGIN_USER.getValor(), mapaSessaoPessoa);
		}else{
			//Caso já exista alguém na sessão atual, ela é encerrada e o novo usuario é adicionado.
			httpSession.invalidate();
			mapaSessaoPessoa.put(pessoa.getEmail(), pessoa);
			httpSession.setAttribute(ConstantesWebFitness.LOGIN_USER.getValor(), mapaSessaoPessoa);
		}
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

	private void realizaLoginJaas(String login, String senha, HttpServletRequest request) throws Exception {
		request.setAttribute(AtributoHttpRequest.ATRIBUTO_LOGIN.getValor(), login);
		request.setAttribute(AtributoHttpRequest.ATRIBUTO_SENHA.getValor(), senha);
		request.login(login, senha);
	}
}
