/**
 * Desenvolvido por Everton 18/07/2016
 */
package br.com.webfitness.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.MensagemDTO;

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
	@Getter @Setter
	private boolean musculo33, musculo66, musculo100;
	@Getter @Setter
	private boolean gordo33, gordo66, gordo100;
	
	@Getter @Setter
	private List<MensagemDTO> mensagensRecentes;
	
	@PostConstruct
	public void init(){
		setPagina("dadosPessoais.xhtml");
	}
	
	/**
	 * @Descrição: Método utilizado para chamar a página correta quando o usuário alterar uma aba na página principal do perfil. 
	 */
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
	
	/**
	 * @Descrição: Método responsável por atualizar o percentual da pessoa quando alguém votar nela. 
	 */
	public void votacao(String tipo, Long porcentagem){
		if(tipo.equals("frango")){
			atualizaFrango(porcentagem);
		}else if(tipo.equals("musculo")){
			atualizaMusculo(porcentagem);
		}else if(tipo.equals("gordo")){
			atualizaGordo(porcentagem);
		}
	}
	
	/**
	 * @Descrição: Verifica se a pessoa que vai votar, já votou nessa pessoa. 
	 */
	public boolean usuarioVotou(){
		return false;
	}
	
	/**
	 * @Descrição: redireciona para a página de mensagens 
	 */
	public String lerTodasMensagens(){
		return "";
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
			musculo33 = true;
			musculo66 = false;
			musculo100= false;
		}else if(porcentagem == NIVEL_2){
			musculo33 = true;
			musculo66 = true;
			musculo100= false;
		}else if(porcentagem == NIVEL_3){
			musculo33 = true;
			musculo66 = true;
			musculo100= true;
		}
	}
	
	private void atualizaGordo(Long porcentagem) {
		if(porcentagem == NIVEL_1){
			gordo33 = true;
			gordo66 = false;
			gordo100= false;
		}else if(porcentagem == NIVEL_2){
			gordo33 = true;
			gordo66 = true;
			gordo100= false;
		}else if(porcentagem == NIVEL_3){
			gordo33 = true;
			gordo66 = true;
			gordo100= true;
		}
	}
}
