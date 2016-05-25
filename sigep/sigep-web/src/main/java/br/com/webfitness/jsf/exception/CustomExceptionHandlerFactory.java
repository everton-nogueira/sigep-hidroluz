/**
 * Desenvolvido por Everton 20/05/2016
 */
package br.com.webfitness.jsf.exception;

/**
 * @author Everton
 * Data: 20/05/2016
 */

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;
 
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
    private ExceptionHandlerFactory parent;
 
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }
 
    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler handler = new CustomExceptionHandler(parent.getExceptionHandler());
        return handler;
    }
 
}
