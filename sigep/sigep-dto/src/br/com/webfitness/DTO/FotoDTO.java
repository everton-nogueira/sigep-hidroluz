package br.com.webfitness.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class FotoDTO {
	@Getter @Setter
	private Integer idFoto;
	
	@Getter @Setter
	private String localizacao;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private Date dataFoto;
	
	@Getter @Setter
	private boolean statusPerfil;
	
}
