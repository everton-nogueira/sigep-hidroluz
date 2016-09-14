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
import javax.persistence.JoinTable;
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
		@NamedQuery(name="selectAll", query="SELECT p FROM Pessoa p"),
		@NamedQuery(name="selectLogin", query="SELECT p FROM Pessoa p WHERE p.email =:email")
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
	private Integer relacionamento;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private Date dataNascimento;
	
	@Getter @Setter
	private String senha;
	
	@Getter @Setter
	private String email;

	@ManyToOne
	@JoinColumn(name = "academia_idAcademia")
	@Getter @Setter
	private Academia academia;
	
	@ManyToOne
	@JoinColumn(name = "endereco_idEndereco")
	@Getter @Setter
	private Endereco endereco;
	
	@OneToMany (mappedBy = "pessoa")
	@Getter @Setter
	private List<Pagina> paginas;
	
	@OneToMany (mappedBy = "pessoa")
	@Getter @Setter
	private List<Video> Videos;
	
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "pessoa")
	@Getter @Setter
	private List<Foto> fotos;
	
	@OneToMany (cascade = CascadeType.ALL , mappedBy = "pessoa")
	@Getter @Setter
	private List<HistoricoMedida> historicoMedidas;
	
	@OneToMany (mappedBy = "pessoa")
	@Getter @Setter
	private List<Dieta> dietas;
	
	@OneToMany (mappedBy = "amigo")
	@Getter @Setter
	private List<Amizade> amigos;
	
	@OneToMany (mappedBy = "pessoaOrigem")
	@Getter @Setter
	private List<PessoaMensagem> mensagensEnviadas;

	@OneToMany (mappedBy = "pessoaDestino")
	@Getter @Setter
	private List<PessoaMensagem> mensagensRecebidas;
	
	@ManyToMany(mappedBy = "pessoas")
	@Getter @Setter
	private List<Telefone> telefones;
	
	@OneToMany(mappedBy = "pessoa")
	@Getter @Setter
	private List<Treino> treinos;

	@ManyToMany
	@JoinTable(name = "pessoa_has_funcao" , 
			joinColumns = @JoinColumn(name = "pessoa_idPessoa"),
			inverseJoinColumns = @JoinColumn(name = "funcao_idFuncao"))
	@Getter @Setter
	private List<Funcao> funcoes;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	
}