/**
 * Desenvolvido por Everton 01/05/2016
 */
package br.com.webfitness.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 01/05/2016
 */
@Entity
public class PessoaMensagem implements Serializable{
	private static final long serialVersionUID = 8655605307491069252L;

	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idPessoaOrigem")
	private Pessoa pessoaOrigem;
	
	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idPessoaDestino")
	private Pessoa pessoaDestino;
	
	@Id
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "idMensagem")
	private Mensagem mensagem;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result
				+ ((pessoaDestino == null) ? 0 : pessoaDestino.hashCode());
		result = prime * result
				+ ((pessoaOrigem == null) ? 0 : pessoaOrigem.hashCode());
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
		PessoaMensagem other = (PessoaMensagem) obj;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (pessoaDestino == null) {
			if (other.pessoaDestino != null)
				return false;
		} else if (!pessoaDestino.equals(other.pessoaDestino))
			return false;
		if (pessoaOrigem == null) {
			if (other.pessoaOrigem != null)
				return false;
		} else if (!pessoaOrigem.equals(other.pessoaOrigem))
			return false;
		return true;
	}
	
}
