/**
 * Desenvolvido por Everton 18/04/2016
 */
package br.com.webfitness.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.com.webfitness.DTO.PessoaDTO;

/**
 * @author Everton
 * Data: 18/04/2016
 */
@ManagedBean
@ViewScoped
public class CadastroPessoaMBean {
	
	private PessoaDTO pessoa;
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public String onFlowProcess(FlowEvent event) {
    	return event.getNewStep();
    }
}
