//$Id$
package com.test.capitalfloat;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ApplicationBean extends ActionSupport implements ServletRequestAware, ServletResponseAware 
{
	private ValueStack stack = null;
    private HashMap<String, Object> context =  null;
    protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public void addToValueStack(String key, Object value)
	{
		 stack = stack == null ? ActionContext.getContext().getValueStack() : stack;
        if (context == null)
        {
            context = new HashMap<String, Object>();
            stack.push(context);
        }
        context.put(key, value);
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
