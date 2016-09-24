/**
 * 
 */
package br.com.webfitness.DTO;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.webfitness.entidades.Foto;
import br.com.webfitness.entidades.Pessoa;
import br.com.webfitness.entidades.Video;

/**
 * @author Belgrano
 * @Data: 22/09/2016
 */
public class PostagemDTO {
	@Getter @Setter
	private Integer idPostagem;
	@Getter @Setter
	private String texto;
	@Getter @Setter
	private Date dataPostagem;
	@Getter @Setter
	private Pessoa pessoa;
	@Getter @Setter
	private List<Foto> fotos;
	@Getter @Setter
	private List<Video> videos;
}
