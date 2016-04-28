package br.com.webfitness.entidades;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willian
 * Data: 27/04/2016
 */
public class HistoricoMedida {
	@Getter @Setter
	@Id
	private Integer idMedida;
	@Getter @Setter
	private Date dataMedicao;
	@Getter @Setter
	private float brancoEsquerdo;
	@Getter @Setter
	private float brancoDireito;
	@Getter @Setter
	private float anteBracoEsquerdo;
	@Getter @Setter
	private float anteBracoDireito;
	@Getter @Setter
	private float ombro;
	@Getter @Setter
	private float torax;
	@Getter @Setter
	private float abdomem;
	@Getter @Setter
	private float gluteos;
	@Getter @Setter
	private float coxaEsquerda;
	@Getter @Setter
	private float coxaDireita;
	@Getter @Setter
	private float panturrilhaEsquerda;
	@Getter @Setter
	private float panturrilhaDireita;
	@ManyToOne
	private Pessoa pessoa;

}
