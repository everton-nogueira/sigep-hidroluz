package br.com.webfitness.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum PessoaStatus {
	
	INATIVO(0, "Inativo"),
	ATIVO(1, "Ativo");
	
	@Getter @Setter
	private Integer id;
	@Getter @Setter
	private String valor;
	
	public static Integer recuperaId(String valor){
		for (PessoaStatus status : values()) {
			if(status.getValor().equals(valor)){
				return status.getId();
			}
		}
		return null;
	}
	
	public static String recuperaNome(Integer id){
		for (PessoaStatus status : values()) {
			if(status.getId().equals(id)){
				return status.getValor();
			}
		}
		return null;
	}
}
