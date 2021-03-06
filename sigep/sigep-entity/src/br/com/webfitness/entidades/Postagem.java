/**
 * 
 */
package br.com.webfitness.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @Autor Belgrano
 * @Data:  14/09/2016
 */
@Entity
@NamedQueries(value = { @NamedQuery(name="Postagem.selectAll", query="SELECT post FROM Postagem post order by post.dataPostagem desc") } )
public class Postagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1262250350948582262L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer idPostagem;
	
	@Getter @Setter
	private String texto;
	
	@Getter @Setter
	private Date dataPostagem;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_idPessoa")
	@Getter @Setter
	private Pessoa pessoa;
	
	@ManyToMany
	@JoinTable(name = "postagem_has_foto" , 
	joinColumns = @JoinColumn(name = "postagem_idPostagem"),
	inverseJoinColumns = @JoinColumn(name = "foto_idFoto"))
	@Getter @Setter
	private List<Foto> fotos;
	
	@ManyToMany
	@JoinTable(name = "postagem_has_video" , 
	joinColumns = @JoinColumn(name = "postagem_idPostagem"),
	inverseJoinColumns = @JoinColumn(name = "video_idVideo"))
	@Getter @Setter
	private List<Video> videos;
	
}
