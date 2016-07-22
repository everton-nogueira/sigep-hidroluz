/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.adapter;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.dominio.Relacionamento;
import br.com.webfitness.entidades.Pessoa;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public class PessoaAdapter implements Adapter<Pessoa, PessoaDTO> 
{
	EnderecoAdapter enderecoAdapter = new EnderecoAdapter();
	
	@Override
	public Pessoa getEntidade(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(dto.getIdPessoa());
		pessoa.setNome(dto.getNome());
		pessoa.setSexo(dto.getSexo());
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setSenha(dto.getSenha());
		pessoa.setEmail(dto.getEmail());
		pessoa.setRelacionamento(Relacionamento.recuperaId(dto.getRelacionamento()));
		pessoa.setDescricao(dto.getDescricao());
//		pessoa.setAcademia(dto.getAcademia());
		pessoa.setEndereco(enderecoAdapter.getEntidade(dto.getEndereco()));
//		pessoa.setTelefone(dto.getTelefone());
//		pessoa.setPaginas(dto.getPaginas());
//		pessoa.setVideos(dto.getVideos());
//		pessoa.setFotos(dto.getFotos());
//		pessoa.setHistoricoMedidas(dto.getHistoricoMedidas());
//		pessoa.setDietas(dto.getDietas());
//		pessoa.setAmigos(dto.getAmigos());
//		pessoa.setMensagensEnviadas(dto.getMensagensEnviadas());
//		pessoa.setSuplementos(dto.getSuplementos());
//		pessoa.setTreinos(dto.getTreinos());
//		pessoa.setFuncoes(dto.getFuncoes());
		return pessoa;
	}

	@Override
	public PessoaDTO getDTO(Pessoa entidade) {
		PessoaDTO dto = new PessoaDTO();
		dto.setIdPessoa(entidade.getIdPessoa());
		dto.setNome(entidade.getNome());
		dto.setSexo(entidade.getSexo().equals("M") ? "Masculino" : "Feminino");
		dto.setDataNascimento(entidade.getDataNascimento());
		dto.setSenha(entidade.getSenha());
		dto.setEmail(entidade.getEmail());
		dto.setRelacionamento(Relacionamento.recuperaNome(entidade.getRelacionamento()));
		dto.setDescricao(entidade.getDescricao());
//		dto.setAcademia(entidade.getAcademia());
		dto.setEndereco(enderecoAdapter.getDTO(entidade.getEndereco()));
//		dto.setTelefone(entidade.getTelefone());
//		dto.setPaginas(entidade.getPaginas());
//		dto.setVideos(entidade.getVideos());
//		dto.setFotos(entidade.getFotos());
//		dto.setHistoricoMedidas(entidade.getHistoricoMedidas());
//		dto.setDietas(entidade.getDietas());
//		dto.setAmigos(entidade.getAmigos());
//		dto.setMensagensEnviadas(entidade.getMensagensEnviadas());
//		dto.setSuplementos(entidade.getSuplementos());
//		dto.setTreinos(entidade.getTreinos());
//		dto.setFuncoes(entidade.getFuncoes());
		return dto;
	}
	
}
