/**
 * Desenvolvido por Everton 18/05/2016
 */
package br.com.webfitness.dominio;


/**
 * @author Everton
 * Data: 18/05/2016
 */
public enum AtributoHttpRequest {
	ATRIBUTO_LOGIN("j_username", String.class),  
	ATRIBUTO_SENHA("j_password", String.class);

	private String valor;
	private Class<?> tipoDado;

	private AtributoHttpRequest(String valor, Class<?> tipoDado)
	{
		this.valor = valor;
		this.tipoDado = tipoDado;
	}

	public String getValor()
	{
		return this.valor;
	}

	public Class<?> getTipoDado()
	{
		return this.tipoDado;
	}
}
