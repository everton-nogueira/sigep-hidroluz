/**
 * Desenvolvido por Everton 14/09/2016
 */
package br.com.webfitness.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.constante.ObjetivoTreino;
import br.com.webfitness.entidades.Exercicio;
import br.com.webfitness.entidades.GrupoMuscular;
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
@ViewScoped
public class TreinoMBean {
	
	@Inject
	private LoginServiceLocal loginService;
	
	@Inject
	private TreinoServiceLocal treinoService;

	private Exercicio exercicio;
	
	private List<Treino> treinosAtuais;
	
	private TreinoExercicio treinoExercicio;
	
	private GrupoMuscular grupoMuscular;
	
	@Getter
	private List<ObjetivoTreino> objetivos = Arrays.asList(ObjetivoTreino.values());
	
	
	@Getter @Setter
	private Treino treino;
	
	@Getter @Setter
	private TreinoExercicio exercicioDoTreino;
	
	@PostConstruct
	public void init(){
		treino = new Treino();
		treino.setExerciciosDoTreino(new ArrayList<TreinoExercicio>());
	}
	
	public void carregarModal(){
		exercicio = treinoExercicio.getExercicio();
	}
	
	public void cadastrarTreino(){
		
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
	
	public List<GrupoMuscular> listGrupoMuscular(){
		return treinoService.findAllGrupoMuscular();
	}
	
	public List<Exercicio> listExercicioByGrupoMuscular(){
		return treinoService.findExercicioByGrupoMuscular(getGrupoMuscular());
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

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
}
