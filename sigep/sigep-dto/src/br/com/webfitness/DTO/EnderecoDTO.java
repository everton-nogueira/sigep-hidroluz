/**
 * Desenvolvido por Everton 22/07/2016
 */
package br.com.webfitness.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Everton
 * Data: 22/07/2016
 */
public class EnderecoDTO {
	@Getter @Setter
	private Integer idEndereco;
	
	@Getter @Setter
	private String estado;
	
	@Getter @Setter
	private String cidade;
	
	@Getter @Setter
	private String pais;
	
	@Getter @Setter
	private String endereco;
	
	@Getter @Setter
	private String pontoReferencia;
	
	@Getter @Setter
	private List<PessoaDTO> pessoas;
}
