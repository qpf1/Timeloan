package com.rg1803.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CharacterEncodingFilter implements Filter{
	 private String encoding="";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 this.encoding = filterConfig.getInitParameter("Encoding");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;
        
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
