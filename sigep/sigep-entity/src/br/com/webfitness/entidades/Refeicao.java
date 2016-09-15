/**
 * 
 */
package br.com.webfitness.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @Autor Belgrano
 * @Data:  15/09/2016
 */
@Entity
public class Refeicao {
	
	@Id
	@Getter @Setter
	private Integer idRefeicao;
	
	@Getter @Setter
	private Date horario;
	
	@Getter @Setter
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "dieta_idDieta")
	@Getter @Setter
	private Dieta dieta;
	
	@ManyToMany(mappedBy = "refeicoes")
	@Getter @Setter
	private List<Alimento> alimentos;
	
	@ManyToMany(mappedBy = "refeicoes")
	@Getter @Setter
	private List<Suplemento> suplementos;
	
	
}
