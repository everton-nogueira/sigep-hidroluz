/**
 * Desenvolvido por Éverton Nogueira em 14/09/2016
 */
package br.com.webfitness.util;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.constante.ConstantesWebFitness;

/**
 * @Autor Everton
 * @Data  14/09/2016
 */
public class Authenticator {
	private static PessoaDTO usuarioLogado;
	
	public static PessoaDTO getUsuarioLogado(){
		if(usuarioLogado == null){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			usuarioLogado = buscaPessoaDTOSessao(request);
		}
		return usuarioLogado;
	}
	
	public static void removeUsuarioLogado(){
		usuarioLogado = null;
	}
	
	public static PessoaDTO recuperaPessoaSessao(HttpSession httpSession, HttpServletRequest httpRequest) {
		if (httpSession != null && httpRequest != null) {
			return buscaPessoaDTOSessao(httpRequest);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	private static PessoaDTO buscaPessoaDTOSessao(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, PessoaDTO> mapaSessaoPessoa = (Map<String, PessoaDTO>) session.getAttribute(ConstantesWebFitness.LOGIN_USER.getValor());
		if (mapaSessaoPessoa != null) {
			usuarioLogado = mapaSessaoPessoa.get(request.getRemoteUser()); 
			return usuarioLogado;
		}
		return null;
	}
	
}
