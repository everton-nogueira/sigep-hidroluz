/**
 * Desenvolvido por Éverton Nogueira em 20/09/2016
 */
package br.com.webfitness.constante;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Éverton Nogueira
 * @Data 20/09/2016
 *
 */
@AllArgsConstructor
public enum ObjetivoTreino {
	HIPERTROFIA(0, "Hipertrofia"),
	PERDA_PESO (1, "Perda de Peso"),
	RESISTENCIA(2, "Ganho de Resistência"),
	GANHO_FORCA(3, "Ganho de Força");
	
	@Getter
	private Integer valor;
	@Getter
	private String label;
}
