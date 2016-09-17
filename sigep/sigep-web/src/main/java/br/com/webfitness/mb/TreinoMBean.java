/**
 * Desenvolvido por Everton 14/09/2016
 */
package br.com.webfitness.mb;

import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.Treino;
import br.com.webfitness.entidades.TreinoExercicio;
import br.com.webfitness.servico.LoginServiceLocal;
import br.com.webfitness.servico.TreinoServiceLocal;
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
	
	@Inject
	private TreinoServiceLocal treinoService;

	private Exercicio exercicio;
	
	private List<Treino> treinosAtuais;
	
	private TreinoExercicio treinoExercicio;
	

	public void carregarModal(){
		exercicio = treinoExercicio.getExercicio();
	}
	
	public List<Treino> obtemTreinosAtuais(){
		PessoaDTO pessoa = loginService.buscaPessoa(Authenticator.getUsuarioLogado().getIdPessoa());
		if(pessoa.getTreinos() != null && !pessoa.getTreinos().isEmpty()){
			List<Treino> treinosAtuais = treinoService.getTreinoAtual(pessoa);
			Collections.sort(treinosAtuais);
			return treinosAtuais;
		}
		return null;
	}

	public List<Treino> getTreinosAtuais() {
		if(treinosAtuais == null){
			setTreinosAtuais(obtemTreinosAtuais());
		}
		return treinosAtuais;
	}

	public void setTreinosAtuais(List<Treino> treinosAtuais) {
		this.treinosAtuais = treinosAtuais;
	}
	
	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public TreinoExercicio getTreinoExercicio() {
		return treinoExercicio;
	}

	public void setTreinoExercicio(TreinoExercicio treinoExercicio) {
		this.treinoExercicio = treinoExercicio;
	}

}
