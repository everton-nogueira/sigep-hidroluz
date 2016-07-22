/**
 * Desenvolvido por Everton 19/04/2016
 */
package br.com.webfitness.DTO;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.Getter;
import lombok.Setter;

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
//	@Getter @Setter
//	private AcademiaDTO academia;
	@Getter @Setter
	private EnderecoDTO endereco;
//	@Getter @Setter
//	private TelefoneDTO telefone;
//	@Getter @Setter
//	private List<PaginaDTO> paginas;
//	@Getter @Setter
//	private List<VideoDTO> Videos;
//	@Getter @Setter
//	private List<FotoDTO> fotos;
//	@Getter @Setter
//	private List<HistoricoMedidaDTO> historicoMedidas;
//	@Getter @Setter
//	private List<DietaDTO> dietas;
//	@Getter @Setter
//	private List<AmizadeDTO> amigos;
//	@Getter @Setter
//	private List<PessoaMensagemDTO> mensagensEnviadas;
//	@Getter @Setter
//	private List<SuplementoDTO> suplementos;
//	@Getter @Setter
//	private List<TreinoDTO> treinos;
//	@Getter @Setter
//	private List<FuncaoDTO> funcoes;
	
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
