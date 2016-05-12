/**
 * Desenvolvido por Everton 08/05/2016
 */
package br.com.webfitness.mb;

import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 08/05/2016
 */
@ManagedBean
public class LoginMBean {

	@Getter @Setter
	private String login;
	@Getter @Setter
	private String senha;
	
	public void logar() {
		
	}
}
