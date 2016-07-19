/**
 * Desenvolvido por Everton 18/07/2016
 */
package br.com.webfitness.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 18/07/2016
 */
@ManagedBean
@RequestScoped
public class PerfilMBean implements Serializable{
	private static final long serialVersionUID = -5653002075025576525L;
	
	private static final int NIVEL_1 = 33;
	private static final int NIVEL_2 = 66;
	private static final int NIVEL_3 = 100;
	
	@Getter @Setter
	private String pagina;
	
	@Getter @Setter
	private boolean frango33, frango66, frango100;
	
	@PostConstruct
	public void init(){
		setPagina("dadosPessoais.xhtml");
	}
	
	public void mudaAba(String aba){
		switch (aba) {
			case "pessoal"  : setPagina("dadosPessoais.xhtml"); break;
			case "medidas"  : setPagina("medidas.xhtml"); break;
			case "fotos"    : setPagina("fotos.xhtml"); break;
			case "videos"   : setPagina("videos.xhtml"); break;
			case "postagens": setPagina("postagem.xhtml"); break;
			default: setPagina("dadosPessoais.xhtml");
		}
	}
	
	public void votacao(String tipo, Long porcentagem){
		if(tipo.equals("frango")){
			atualizaFrango(porcentagem);
		}else if(tipo.equals("musculo")){
			atualizaMusculo(porcentagem);
		}else if(tipo.equals("gordo")){
			atualizaGordo(porcentagem);
		}
	}
	
	public boolean usuarioVotou(){
		return false;
	}

	private void atualizaFrango(Long porcentagem) {
		if(porcentagem == NIVEL_1){
			frango33 = true;
			frango66 = false;
			frango100= false;
		}else if(porcentagem == NIVEL_2){
			frango33 = true;
			frango66 = true;
			frango100= false;
		}else if(porcentagem == NIVEL_3){
			frango33 = true;
			frango66 = true;
			frango100= true;
		}
	}
	
	private void atualizaMusculo(Long porcentagem) {
		if(porcentagem == NIVEL_1){
			
		}else if(porcentagem == NIVEL_2){
			
		}else if(porcentagem == NIVEL_3){
			
		}
	}
	
	private void atualizaGordo(Long porcentagem) {
		if(porcentagem == NIVEL_1){
			
		}else if(porcentagem == NIVEL_2){
			
		}else if(porcentagem == NIVEL_3){
			
		}
	}
}
