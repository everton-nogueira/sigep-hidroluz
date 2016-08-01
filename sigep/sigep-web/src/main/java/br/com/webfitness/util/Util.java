package br.com.webfitness.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean
public class Util {


    public static void criarAviso(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, txt, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }

    public static void criarAvisoErro(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, txt, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }

    public static void resetarFormulario(String id) {
        RequestContext.getCurrentInstance().reset(id);
    }

    public static void executarJavaScript(String comando) {
        RequestContext.getCurrentInstance().execute(comando);
    }

    public static void atualizarForm(String id) {
        RequestContext.getCurrentInstance().update(id);
    }

    public static void redirecionarPagina(String pagina) {
        String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
