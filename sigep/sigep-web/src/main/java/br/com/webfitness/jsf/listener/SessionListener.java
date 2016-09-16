/**
 * Desenvolvido por Everton 25/05/2016
 */
package br.com.webfitness.jsf.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.constante.ConstantesWebFitness;
import br.com.webfitness.util.Authenticator;

/**
 * @author Everton
 * Data: 25/05/2016
 */
public class SessionListener implements HttpSessionListener {
    
	private static int totalActiveSessions;
	
    public void sessionCreated(HttpSessionEvent event) {        
         System.out.println("Sessão criada");
         System.out.println("Sessões ativas: "+(++totalActiveSessions));
    }
 
    @SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent event) {  
    	 Authenticator.removeUsuarioLogado();
         String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
         Map<String, PessoaDTO> mapaUsuarios = (Map<String, PessoaDTO>) event.getSession().getAttribute(ConstantesWebFitness.LOGIN_USER.getValor());
         String nomeUsuario = "";
         if(mapaUsuarios != null){
        	 for (Entry<String, PessoaDTO> usuario : mapaUsuarios.entrySet()) {
				nomeUsuario = usuario.getValue().getNome();
			}
         }
         System.out.println("Sessão do usuario "+nomeUsuario+" encerrada. Ultimo Acesso = "+ultimoAcesso);
         System.out.println("Sessões ativas: "+(--totalActiveSessions));
    }
 
}
