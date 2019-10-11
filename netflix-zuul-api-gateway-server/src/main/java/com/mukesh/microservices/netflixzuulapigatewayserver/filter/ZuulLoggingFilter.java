/**
 * 
 */
package com.mukesh.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author mukeshgehani
 *
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter{

	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//Use for configuring that filter has to execute or not we can do some configuration for some request
	//so for them it has to execute or not that validation we can do here.
	@Override
	public boolean shouldFilter() {
		return true;
	}
	// This method is used for implementation of filter
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
		logger.info("Request is -> {} request uri is -> {} ",
				request,request.getRequestURI());
		return null;
	}

	//this method is used for that when filter has to happen
	//pre(before the request)/post(after the request)/error(when error/exception happened in the request) 
	@Override
	public String filterType() {
		return "pre"; //values are "pre" /"post" / "error"
	}

	//Use for setting the priority of filter
	@Override
	public int filterOrder() {
		return 1;
	}

}
