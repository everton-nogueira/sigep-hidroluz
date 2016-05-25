/**
 * Desenvolvido por Everton 08/05/2016
 */
package br.com.webfitness.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
