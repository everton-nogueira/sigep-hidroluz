/**
 * 
 */
package br.com.webfitness.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.entidades.Postagem;
import br.com.webfitness.servico.LoginServiceLocal;
import br.com.webfitness.servico.PostagemServiceLocal;
import br.com.webfitness.util.Authenticator;

/**
 * @author Belgrano
 * @Data: 20/09/2016
 */
@ManagedBean
@ViewScoped
public class PostagemMBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 281943922770679218L;

	@Inject
	private PostagemServiceLocal postagemService;
	
	@Inject
	private LoginServiceLocal loginService;
	
	@Getter @Setter
	private PessoaDTO pessoaSession;
	
	@Getter @Setter
	private List<Postagem> postagens;

	@Getter @Setter
	private String texto;
	
	@PostConstruct
	public void init(){
		carregaPostagens();
	}
	
	/**
	 * @Descrição  
	 * 
	 * @Retorno void
	 */
	private void carregaPostagens() {
		pessoaSession = loginService.buscaPessoa(Authenticator.getUsuarioLogado().getIdPessoa());
		postagens = postagemService.buscaUltimasPostagensPorRelevancia();
	}
	
	public void enviar(){
		postagemService.realizaPostagem(getTexto(),getPessoaSession());
	}
	
	
	
}
