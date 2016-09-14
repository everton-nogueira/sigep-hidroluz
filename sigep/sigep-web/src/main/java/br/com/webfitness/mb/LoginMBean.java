/**
 * Desenvolvido por Everton 08/05/2016
 */
package br.com.webfitness.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.servico.LoginServiceLocal;
import br.com.webfitness.util.Authenticator;

/**
 * @author Everton
 * Data: 08/05/2016
 */
@ManagedBean
@SessionScoped
public class LoginMBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private String login;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private PessoaDTO pessoa;
	@EJB
	private LoginServiceLocal loginService;
	
	public String logar() {
		try {
			pessoa = loginService.realizaLogin(login, senha);
			return "usuario/index.xhtml?faces-redirect=true";
		} catch (ServletException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Login e/ou senha inválidos!"));
			return null;
		}
	}
	
	public String sair(){
		loginService.realizaLogout();
		Authenticator.removeUsuarioLogado();
		return "/login.xhtml?faces-redirect=true";
	}
	
	public void limpar() {
		setLogin("");
		setSenha("");
	}
}
