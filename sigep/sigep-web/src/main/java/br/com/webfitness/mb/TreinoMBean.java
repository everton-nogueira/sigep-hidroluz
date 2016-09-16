/**
 * Desenvolvido por Everton 14/09/2016
 */
package br.com.webfitness.mb;

import java.util.Collections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.Treino;
import br.com.webfitness.servico.LoginServiceLocal;
import br.com.webfitness.util.Authenticator;

/**
 * @author Everton
 * Data: 14/09/2016
 */
@ManagedBean
@RequestScoped
public class TreinoMBean {
	
	@Inject
	private LoginServiceLocal loginService;

	private Exercicio exercicio;
	
	private Treino ultimoTreino;
	

	public void carregarModal(Integer index){
		exercicio = ultimoTreino.getExerciciosDoTreino().get(index).getExercicio();
	}
	
	public Treino obtemTreinoAtual(){
		PessoaDTO pessoa = loginService.buscaPessoa(Authenticator.getUsuarioLogado().getIdPessoa());
		if(pessoa.getTreinos() != null && !pessoa.getTreinos().isEmpty()){
			Collections.sort(pessoa.getTreinos());
			return pessoa.getTreinos().get(pessoa.getTreinos().size() - 1);
		}
		return null;
	}

	public Treino getUltimoTreino() {
		if(ultimoTreino == null){
			setUltimoTreino(obtemTreinoAtual());
		}
		return ultimoTreino;
	}

	public void setUltimoTreino(Treino ultimoTreino) {
		this.ultimoTreino = ultimoTreino;
	}
	
	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}
