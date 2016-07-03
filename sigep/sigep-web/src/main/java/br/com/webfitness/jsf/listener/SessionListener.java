/**
 * Desenvolvido por Everton 25/05/2016
 */
package br.com.webfitness.jsf.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Everton
 * Data: 25/05/2016
 */
public class SessionListener implements HttpSessionListener {
    
	private static int totalActiveSessions;
	
    public void sessionCreated(HttpSessionEvent event) {        
         System.out.println("Sess�o criada " + event.getSession().getId());
         System.out.println("Sess�es ativas: "+(++totalActiveSessions));
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {     
         String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
         System.out.println("Sess�o expirada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);
         System.out.println("Sess�es ativas: "+(--totalActiveSessions));
    }
 
}
