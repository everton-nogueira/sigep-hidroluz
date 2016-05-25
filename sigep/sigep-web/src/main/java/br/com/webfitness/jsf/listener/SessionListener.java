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
    
	   
    public void sessionCreated(HttpSessionEvent event) {        
         System.out.println("Sessão criada " + event.getSession().getId());
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {     
         String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
         System.out.println("Sessão expirada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);
    }
 
}
