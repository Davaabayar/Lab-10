package edu.mum.cs.cs427.lab10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter
public class TotalHitCounter implements Filter{

	private int totalHit;
	
	public void  init(FilterConfig config) throws ServletException {
		System.out.println("Filter init called");
		totalHit = 0;		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		totalHit++;
		System.out.println("Filter doFilter totalHit counted");
		request.setAttribute("totalHit", totalHit);
		chain.doFilter(request,response);
	}
}
