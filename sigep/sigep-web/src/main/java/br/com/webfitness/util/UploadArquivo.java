package br.com.webfitness.util;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;

public class UploadArquivo {
	private String caminho;
	private String caminhoBack;
	private byte[] arquivo;
	private String nome;

	public UploadArquivo() {
	}


	public String getNome() {
		return nome;
	}


	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getRealPath() {
		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
		return context.getRealPath("/");
	}

	//fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser gravado.
	public void fileUpload(FileUploadEvent event, String type, String diretorio, String diretoriobackup) {
		try {
			this.nome = new java.util.Date().getTime() + type;
			this.caminho = getRealPath() + diretorio + getNome();
			this.caminhoBack = diretoriobackup+getNome();
			this.arquivo = event.getFile().getContents();
			File file = new File(getRealPath() + diretorio);
			file.mkdirs();
		} catch (Exception ex) {
			System.out.println("Erro no upload do arquivo" + ex);
		}
	}

	//grava o arquivo no diretório informado.
	public void gravar(){
		System.out.println(this.nome+" || "+this.caminho+" || "+this.caminhoBack+" || "+this.arquivo);
		//realizar backup das imagens em uma pasta fora do servidor de aplicação
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(this.caminho);
			fos.write(this.arquivo);
			fos.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public void back() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(this.caminhoBack);
			fos.write(this.arquivo);
			fos.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public String retornaFoto() {
		if (this.caminho != null) {
			return this.caminho;
		} else {
			return "/resources/fotos/foto.gif";
		}
	}

}