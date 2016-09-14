/**
 * Desenvolvido por Everton 14/09/2016
 */
package br.com.webfitness.mb;

import java.util.Collections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Treino;
import br.com.webfitness.util.Authenticator;

/**
 * @author Everton
 * Data: 14/09/2016
 */
@ManagedBean
@RequestScoped
public class TreinoMBean {
	
	public Treino getUltimoTreino(){
		PessoaDTO pessoa = Authenticator.getUsuarioLogado();
		Collections.sort(pessoa.getTreinos());
		return pessoa.getTreinos().get(pessoa.getTreinos().size() - 1);
	}
}
