/**
 * Desenvolvido por Éverton Nogueira em 19/09/2016
 */
package br.com.webfitness.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.webfitness.entidades.Exercicio;

/**
 * @author Éverton Nogueira
 * @Data 19/09/2016
 *
 */
@FacesConverter("exercicioConverter")
public class ExercicioConverter implements Converter {
	
	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		if(valor != null){
			return new Exercicio(valor);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object objeto) {
		if(objeto instanceof Exercicio){
			Exercicio exercicio = (Exercicio) objeto;
			return exercicio.getNome();
		}
		return null;
	}

}
