package com.iris.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 常量过滤器
 * 对于每个请求，都注入一些基本常量
 * @author zhangteng
 *
 */
public class ConstantsFilter implements Filter {
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String path = httpRequest.getContextPath();
		String basePath = httpRequest.getScheme() + "://" + httpRequest.getServerName() + ":"
						  + httpRequest.getServerPort() + path + "/";
		request.setAttribute("website", basePath);
        request.setAttribute("staticWebsite", basePath + "resources/");
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
