/**
 * Desenvolvido por Everton e Willian 23/02/2015
 */
package br.com.webfitness.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
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

	@Getter @Setter
	@Id
	private Integer idPessoa;
	@Getter @Setter
	private Telefone telefone;
	@Getter @Setter
	private Academia academia;
	@Getter @Setter
	private Endereco endereco;
	@Getter @Setter
	private String nome;
	private String sexo;
	@Getter @Setter
	private Date dataNascimento;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private String email;
	
	/**
	 * @Descrição: Métodos sobreescritos para o GET sempre pegar pela descrição
	 * E para o SET sempre setar pelo ID para salvar no Banco de Dados. 
	 */
	public String getSexo() {
		return Sexo.getDescricao(sexo);
	}
	public void setSexo(String sexo) {
		if(sexo.length() > Sexo.TAM_ID){
			this.sexo = Sexo.getId(sexo);
		}else{
			this.sexo = sexo;
		}
	}
}

@AllArgsConstructor
enum Sexo{
	F("F", "Feminino"), M("M", "Masculino");
	
	public static final Integer TAM_ID = 1;
	@Getter
	private String id;
	@Getter
	private String valor;
	
	static String getDescricao(String id){
		for (Sexo sexo : Sexo.values()) {
			if(sexo.getId().equals(id)){
				return sexo.getValor();
			}
		}
		return "";
	}
	
	static String getId(String valor){
		for (Sexo sexo : Sexo.values()) {
			if(sexo.getValor().equals(valor)){
				return sexo.getId();
			}
		}
		return "";
	}
}