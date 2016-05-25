/**
 * Desenvolvido por Everton 20/05/2016
 */
package br.com.webfitness.jsf.exception;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * @author Everton
 * Data: 20/05/2016
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;
	//Obtém uma instância do FacesContext
	final FacesContext facesContext = FacesContext.getCurrentInstance();
	//Obtém um mapa do FacesContext
	final Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
	//Obtém o estado atual da navegação entre páginas do JSF
	final NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();

	CustomExceptionHandler(ExceptionHandler exception) {
		this.wrapped = exception;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {

		final Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents().iterator();
		while (iterator.hasNext()) {
			ExceptionQueuedEvent event = iterator.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable exception = context.getException();
			try {
				exception.printStackTrace();
				if(exception instanceof Exception){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado. Tente novamente mais tarde!", ""));
				}
				// Seta a navegação para uma página padrão.
				//navigationHandler.handleNavigation(facesContext, null, "/usuario/index.xhtml");
				facesContext.renderResponse();
			} finally {
				// Remove a exeção da fila
				iterator.remove();
			}
		}
	}
}