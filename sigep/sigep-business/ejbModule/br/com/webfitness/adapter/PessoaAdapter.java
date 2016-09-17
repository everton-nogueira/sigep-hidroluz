/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.adapter;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.dominio.PessoaStatus;
import br.com.webfitness.dominio.Relacionamento;
import br.com.webfitness.entidades.Pessoa;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public class PessoaAdapter implements Adapter<Pessoa, PessoaDTO> 
{
	
	@Override
	public Pessoa getEntidade(PessoaDTO dto) {
		Pessoa pessoa = preencheParteBasicaEntidade(dto);
		pessoa.setEndereco(dto.getEndereco());
		pessoa.setAcademia(dto.getAcademia());
		pessoa.setTelefones(dto.getTelefones());
		pessoa.setComunidades(dto.getComunidades());
		pessoa.setVideos(dto.getVideos());
		pessoa.setFotos(dto.getFotos());
		pessoa.setHistoricoMedidas(dto.getHistoricoMedidas());
		pessoa.setDietas(dto.getDietas());
		pessoa.setAmigos(dto.getAmigos());
		pessoa.setMensagensEnviadas(dto.getMensagensEnviadas());
		pessoa.setTreinos(dto.getTreinos());
		pessoa.setFuncoes(dto.getFuncoes());
		pessoa.setPostagens(dto.getPostagens());
		return pessoa;
	}
	
	@Override
	public Pessoa preencheParteBasicaEntidade(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(dto.getIdPessoa());
		pessoa.setNome(dto.getNome());
		pessoa.setSexo(dto.getSexo());
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setSenha(dto.getSenha());
		pessoa.setEmail(dto.getEmail());
		pessoa.setRelacionamento(Relacionamento.recuperaId(dto.getRelacionamento()));
		pessoa.setDescricao(dto.getDescricao());
		pessoa.setPessoaStatus(PessoaStatus.recuperaId(dto.getPessoaStatus()));
		return pessoa;
	}

	@Override
	public PessoaDTO getDTO(Pessoa entidade) {
		PessoaDTO dto = preencheParteBasicaDTO(entidade);
		dto.setEndereco(entidade.getEndereco());
		dto.setAcademia(entidade.getAcademia());
		dto.setTelefones(entidade.getTelefones());
		dto.setComunidades(entidade.getComunidades());
		dto.setVideos(entidade.getVideos());
		dto.setFotos(entidade.getFotos());
		dto.setHistoricoMedidas(entidade.getHistoricoMedidas());
		dto.setDietas(entidade.getDietas());
		dto.setAmigos(entidade.getAmigos());
		dto.setMensagensEnviadas(entidade.getMensagensEnviadas());
		dto.setTreinos(entidade.getTreinos());
		dto.setFuncoes(entidade.getFuncoes());
		dto.setPostagens(entidade.getPostagens());
		return dto;
	}

	@Override
	public PessoaDTO preencheParteBasicaDTO(Pessoa entidade) {
		PessoaDTO dto = new PessoaDTO();
		dto.setIdPessoa(entidade.getIdPessoa());
		dto.setNome(entidade.getNome());
		dto.setSexo(entidade.getSexo().equals("M") ? "Masculino" : "Feminino");
		dto.setDataNascimento(entidade.getDataNascimento());
		dto.setSenha(entidade.getSenha());
		dto.setEmail(entidade.getEmail());
		dto.setRelacionamento(Relacionamento.recuperaNome(entidade.getRelacionamento()));
		dto.setDescricao(entidade.getDescricao());
		dto.setPessoaStatus(PessoaStatus.recuperaNome(entidade.getPessoaStatus()));
		return dto;
	}

	
}
