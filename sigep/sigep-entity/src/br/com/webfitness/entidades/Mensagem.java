/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.util.Date;
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
	
	@Getter @Setter
	private Date dataMensagem;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMensagem == null) ? 0 : idMensagem.hashCode());
		result = prime * result
				+ ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result
				+ ((mensagens == null) ? 0 : mensagens.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (idMensagem == null) {
			if (other.idMensagem != null)
				return false;
		} else if (!idMensagem.equals(other.idMensagem))
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (mensagens == null) {
			if (other.mensagens != null)
				return false;
		} else if (!mensagens.equals(other.mensagens))
			return false;
		return true;
	}
}
