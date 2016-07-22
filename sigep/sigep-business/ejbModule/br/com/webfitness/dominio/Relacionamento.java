/**
 * Desenvolvido por Everton 22/07/2016
 */
package br.com.webfitness.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 22/07/2016
 */
@AllArgsConstructor
public enum Relacionamento {
	
	SOLTEIRO(0, "Solteiro(a)"),
	NAMORANDO(1, "Namorando"),
	CASADO(2, "Casado(a)"),
	VIUVO(3, "Viúvo(a)");
	
	@Getter @Setter
	private Integer id;
	@Getter @Setter
	private String valor;
	
	public static Integer recuperaId(String valor){
		for (Relacionamento relacionamento : values()) {
			if(relacionamento.getValor().equals(valor)){
				return relacionamento.getId();
			}
		}
		return null;
	}
	
	public static String recuperaNome(Integer id){
		for (Relacionamento relacionamento : values()) {
			if(relacionamento.getId().equals(id)){
				return relacionamento.getValor();
			}
		}
		return null;
	}
}
