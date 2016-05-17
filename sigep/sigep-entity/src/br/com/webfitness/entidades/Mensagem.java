/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class Mensagem {
	@Id
	@Getter @Setter
	private Integer idMensagem;
	
	@Getter @Setter
	private String mensagem;
	
	@OneToMany (mappedBy = "mensagem")
	@Getter @Setter
	private List<PessoaMensagem> mensagens;
}
