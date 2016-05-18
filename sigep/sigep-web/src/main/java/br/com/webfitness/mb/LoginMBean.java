/**
 * Desenvolvido por Everton 08/05/2016
 */
package br.com.webfitness.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.servico.LoginServiceLocal;

/**
 * @author Everton
 * Data: 08/05/2016
 */
@ManagedBean
@SessionScoped
public class LoginMBean {

	@Getter @Setter
	private String login;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private PessoaDTO pessoa;
	@Inject
	private LoginServiceLocal loginService;
	
	public String logar() {
		pessoa = loginService.realizaLogin(login, senha);
		if(pessoa != null){
			return "usuario/index.xhtml";
		}
		return null;
	}
	
	public void sair(){
		loginService.realizaLogout();
	}
	
	public void limpar() {
		setLogin("");
		setSenha("");
	}
}
