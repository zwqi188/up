package com.ifly.travel.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ImgFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		urlPatterns = { "*.jpg" ,"*.png","*.bmp"}, 
		initParams = { 
				@WebInitParam(name = "Encoding", value = "utf-8")
		})
public class ImgFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ImgFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;
		String uri = hRequest.getRequestURI();
		String decodeUri = URLDecoder.decode(uri, "utf-8");
		if (uri.equals(decodeUri)) {
			chain.doFilter(request, response);
		}else {
			decodeUri = decodeUri.substring(hRequest.getServletContext().getContextPath().length());
			hRequest.getRequestDispatcher(decodeUri).forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
