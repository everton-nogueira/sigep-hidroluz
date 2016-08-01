package br.com.webfitness.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import br.com.webfitness.DTO.FotoDTO;
import br.com.webfitness.util.UploadArquivo;
import br.com.webfitness.util.Util;


@ManagedBean
@ViewScoped
public class FotoPerfilMBean {
	private static final String DIRETORIO = "/resources/imgPessoas/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private UploadArquivo arquivo;
	private FotoDTO foto;
	
	@PostConstruct
	public void init() {
		foto = new FotoDTO();
		arquivo = new UploadArquivo();
	}
	
	public void uploadAction(FileUploadEvent event) {
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO, DIRETORIOBACKUP);
		foto.setDescricao(this.arquivo.getNome());
		this.arquivo.gravar();
		Util.criarAviso("Foto processada!");
		Util.executarJavaScript("PF('dlgfoto').hide();");
		Util.atualizarForm("cadastrar:pic");

	}
	
	public String retornaFoto() {
		if (this.foto != null) {
			if (this.foto.getDescricao() != null) {
				return "/resources/imgPessoas/" + this.foto.getDescricao();
			} else {
				return "/resources/imgPessoas/foto.jpg";
			}
		}
		return "/resources/fotos/imgPessoas.jpg";
	}
}
