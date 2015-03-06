/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.hidroluz.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 23/02/2015
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name="selectAll", query="SELECT p FROM Poco p")
})
public class Poco {

	@Getter @Setter
	@Id
	private Integer idPoco;
	@Getter @Setter
	private Double QtdMetros;
	@Getter @Setter
	private Double QtdRevestimento;
	@Getter @Setter
	private Date DataPerfuracao;
	@Getter @Setter
	private Double VazaoPorHora;
	@Getter @Setter
	private Double ValorTotal;
}
