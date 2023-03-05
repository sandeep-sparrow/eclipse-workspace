package com.test.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		//pre-processing
		if(req.getRequestURI().startsWith("/HPlusSample/orderHistory")||
		   req.getRequestURI().startsWith("/HPlusSample/getProfileDetails")) {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("username")==null) {
				req.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		}
		
		chain.doFilter(req, response);
		// post-processing....
		
	}

	@Override
	public void destroy() {
		
	}

}
