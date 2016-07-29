/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.adapter;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public interface Adapter<ENTIDADE, DTO> {
	
	public ENTIDADE getEntidade(DTO dto);
	public ENTIDADE preencheParteBasicaEntidade(DTO dto);
	public DTO getDTO(ENTIDADE entidade);
	public DTO preencheParteBasicaDTO(ENTIDADE entidade);
}
