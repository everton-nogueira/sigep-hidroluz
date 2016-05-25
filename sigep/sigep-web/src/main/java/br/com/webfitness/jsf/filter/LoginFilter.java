/**
 * Desenvolvido por Everton 24/05/2016
 */
package br.com.webfitness.jsf.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.webfitness.DTO.PessoaDTO;
import br.com.webfitness.constante.ConstantesWebFitness;

/**
 * @author Everton
 * Data: 24/05/2016
 */
public class LoginFilter implements Filter {
	
	private static final String URLS_LIBERADAS = "urlsLiberadas";
	private String[] urlsLiberadas;
	
    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String email = httpRequest.getRemoteUser();
        HttpSession httpSession = httpRequest.getSession(false);
        PessoaDTO pessoa = null;

        if (httpSession != null){
           pessoa = (PessoaDTO) httpSession.getAttribute(ConstantesWebFitness.LOGIN_USER.getValor());
        }
        
        if (contains(httpRequest.getRequestURI(), "css", "js", "png")){
        	chain.doFilter(request, response);
        }else
        {
        	if ((email != null && pessoa != null && pessoa.getEmail().equalsIgnoreCase(email)) || !isFiltered(httpRequest.getRequestURL().toString())){
        		if (!httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)){
        			httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        			httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        			httpResponse.setDateHeader("Expires", 0); // Proxies.
        		}
        		chain.doFilter(request, response);
        	} else {
        		if (httpSession != null){
        			httpSession.invalidate();
        		}
        		
        		System.out.println(String.format("Requisicao a URL restrita sem login identificado: %s  - Redirecionando requisicao para tela de login.",
        				httpRequest.getRequestURL().toString()));
        		
        		String ajaxHeader = httpRequest.getHeader("X-Requested-With");
        		
        		if ("XMLHttpRequest".equals(ajaxHeader))
        		{
        			StringBuilder sb = new StringBuilder();
        			sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        			sb.append("<partial-response><redirect url=\"").append(httpRequest.getContextPath() + "/login.xhtml?faces-redirect=true")
        			.append("\"/></partial-response>");
        			
        			httpResponse.getWriter().print(sb.toString());
        			httpResponse.flushBuffer();
        		}
        		else
        		{
        			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml?faces-redirect=true");
        		}
        	}
        }
    }
    
    /**
     * @Descrição: Não utiliza o filtro para os valores passados 
     * Ex.: CSS, PNG, JS, etc..
     */
    private boolean contains(String URI, String... values){
    	if(URI != null && values != null && values.length > 0){
    		for (String string : values) {
				if(URI.contains(string)){
					return true;
				}
			}
    	}
    	return false;
    }
 
    /**
     * (Ver Javadoc da super classe)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException
    {
       String urls = config.getInitParameter(URLS_LIBERADAS);

       if (urls != null && !urls.isEmpty())
       {
          urlsLiberadas = urls.split("[;,]");

          if (urlsLiberadas == null)
          {
             urlsLiberadas = new String[]{urls};
          }
       }

       System.out.println("Configuracao de URLs liberadas: " + Arrays.toString(urlsLiberadas));
       System.out.println("Filtro de controle de acesso inicializado.");
    }

    private boolean isFiltered(String url)
    {
       boolean result = true;

       if (url != null)
       {
          for (String unfilteredUrl : this.urlsLiberadas)
          {
             if (url.toLowerCase().contains(unfilteredUrl))
             {
                result = false;
                break;
             }
          }
       }

       return result;
    }

 }
