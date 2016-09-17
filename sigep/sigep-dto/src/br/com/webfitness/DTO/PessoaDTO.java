/**
 * Desenvolvido por Everton 19/04/2016
 */
package br.com.webfitness.DTO;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.entidades.Academia;
import br.com.webfitness.entidades.Amizade;
import br.com.webfitness.entidades.Comunidade;
import br.com.webfitness.entidades.Dieta;
import br.com.webfitness.entidades.Endereco;
import br.com.webfitness.entidades.Foto;
import br.com.webfitness.entidades.Funcao;
import br.com.webfitness.entidades.HistoricoMedida;
import br.com.webfitness.entidades.PessoaMensagem;
import br.com.webfitness.entidades.Postagem;
import br.com.webfitness.entidades.Telefone;
import br.com.webfitness.entidades.Treino;
import br.com.webfitness.entidades.Video;

/**
 * @author Everton
 * Data: 19/04/2016
 */
public class PessoaDTO {
	@Getter @Setter
	private Integer idPessoa;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String sexo;
	@Getter @Setter
	private String relacionamento;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private Date dataNascimento;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String pessoaStatus;
	@Getter @Setter
	private Academia academia;
	@Getter @Setter
	private Endereco endereco;
	@Getter @Setter
	private List<Telefone> telefones;
	@Getter @Setter
	private List<Comunidade> comunidades;
	@Getter @Setter
	private List<Video> Videos;
	@Getter @Setter
	private List<Foto> fotos;
	@Getter @Setter
	private List<HistoricoMedida> historicoMedidas;
	@Getter @Setter
	private List<Dieta> dietas;
	@Getter @Setter
	private List<Amizade> amigos;
	@Getter @Setter
	private List<PessoaMensagem> mensagensEnviadas;
	@Getter @Setter
	private List<Treino> treinos;
	@Getter @Setter
	private List<Funcao> funcoes;
	@Getter @Setter
	private List<Postagem> postagens;
	
	public Integer getIdade(){
		Integer idade = 0;
		if(getDataNascimento() != null){
			Calendar dataAtual = new GregorianCalendar();
			Calendar dataNascimento = new GregorianCalendar();
			dataNascimento.setTime(getDataNascimento());
			idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
			dataNascimento.set(Calendar.YEAR, dataAtual.get(Calendar.YEAR));
			//Ainda não fez aniversário
			if(dataAtual.before(dataNascimento)){
				idade = idade - 1;
			}
		}
		return idade;
	}
}
