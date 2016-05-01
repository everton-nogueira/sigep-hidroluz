/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 23/02/2015
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name="selectAll", query="SELECT p FROM Pessoa p")
})
public class Pessoa {

	@Id
	@Getter @Setter
	private Integer idPessoa;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String sexo;
	
	@Getter @Setter
	private Date dataNascimento;
	
	@Getter @Setter
	private String senha;
	
	@Getter @Setter
	private String email;

	@ManyToOne
	@Getter @Setter
	private Academia academia;
	
	@ManyToOne
	@Getter @Setter
	private Endereco endereco;
	
	@ManyToOne
	@Getter @Setter
	private Telefone telefone;
	
	@OneToMany (mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<Pagina> paginas;
	
	@OneToMany (mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<Video> Videos;
	
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<Foto> fotos;
	
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<HistoricoMedida> historicoMedidas;
	
	@OneToMany (mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<Dieta> dietas;
	
	@OneToMany (mappedBy = "amigo")
	@Getter @Setter
	private List<Amizade> amigos;
	
	@OneToMany (mappedBy = "pessoaOrigem")
	@Getter @Setter
	private List<PessoaMensagem> mensagensEnviadas;

	@ManyToMany(mappedBy = "pessoas")
	@Getter @Setter
	private List<Suplemento> suplementos;
	
	@OneToMany(mappedBy = "pessoa")
	@JoinColumn(name="idPessoa")
	@Getter @Setter
	private List<Treino> treinos;
	
}