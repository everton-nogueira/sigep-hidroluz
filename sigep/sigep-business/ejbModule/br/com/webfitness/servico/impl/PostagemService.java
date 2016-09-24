/**
 * 
 */
package br.com.webfitness.servico.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.adapter.PessoaAdapter;
import br.com.webfitness.dao.PostagemDAO;
import br.com.webfitness.entidades.Postagem;
import br.com.webfitness.servico.PostagemServiceLocal;

/**
 * @author Belgrano
 * @Data: 24/09/2016
 */
@Stateless
public class PostagemService implements PostagemServiceLocal{
	
	@Inject
	PostagemDAO postagemDAO;
	
	private PessoaAdapter adapter = new PessoaAdapter();

	@Override
	public List<Postagem> buscaUltimasPostagensPorRelevancia() {
		return postagemDAO.listar(Postagem.class);
	}

	@Override
	public void realizaPostagem(String texto, PessoaDTO pessoaDTO) {
		if(validaPostagem(texto))
		{
			Postagem postagem = montaPostagem(texto,pessoaDTO);
			postagemDAO.salvar(postagem);
		}
	}

	/**
	 * @Descrição 
	 * @Parametros PostagemService
	 * @Retorno Postagem
	 * @param texto
	 * @param pessoaDTO 
	 * @return
	 */
	private Postagem montaPostagem(String texto, PessoaDTO pessoa) {
		Postagem postagem = new Postagem();
		postagem.setTexto(texto);
		postagem.setPessoa(adapter.getEntidade(pessoa));
		postagem.setDataPostagem(new Date());
		return postagem;
	}

	/**
	 * @Descrição 
	 * @Parametros PostagemService
	 * @Retorno boolean
	 * @param texto
	 * @return
	 */
	private boolean validaPostagem(String texto) {
		return !texto.isEmpty();
	}

}
