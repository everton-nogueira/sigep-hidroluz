/**
 * Desenvolvido por Everton 22/07/2016
 */
package br.com.webfitness.adapter;

import br.com.webfitness.DTO.EnderecoDTO;
import br.com.webfitness.entidades.Endereco;

/**
 * @author Everton
 * Data: 22/07/2016
 */
public class EnderecoAdapter implements Adapter<Endereco, EnderecoDTO> {

	@Override
	public Endereco getEntidade(EnderecoDTO dto) {
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(dto.getIdEndereco());
		endereco.setEstado(dto.getEstado());
		endereco.setCidade(dto.getCidade());
		endereco.setPais(dto.getPais());
		endereco.setEndereco(dto.getEndereco());
		endereco.setPontoReferencia(dto.getPontoReferencia());
//		endereco.setPessoas(pessoaAdapter.getListEntidade(dto.getPessoas()));
//		List<Academia> academia;
		return endereco;
	}

	@Override
	public EnderecoDTO getDTO(Endereco entidade) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setIdEndereco(entidade.getIdEndereco());
		dto.setEstado(entidade.getEstado());
		dto.setCidade(entidade.getCidade());
		dto.setPais(entidade.getPais());
		dto.setEndereco(entidade.getEndereco());
		dto.setPontoReferencia(entidade.getPontoReferencia());
//		dto.setPessoas(pessoaAdapter.getListDTO(entidade.getPessoas()));
		return dto;
	}

}
