//$Id$
package com.test.capitalflot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class StringParser implements ModelDriven<StringParserBean>, ServletRequestAware, ServletResponseAware{
	private StringParserBean parserBean = null;
	private ValueStack stack = null;
    private HashMap<String, Object> context =  null;
    private String resultString = "";
    protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public String parseString() throws IOException
	{
		getResultString(parserBean.getString(), 0,0, parserBean.getString().length(),"");
		addToValueStack("string", resultString);
		
		 // Write result into HttpServletResponse object
		/*
			response.setContentType("text/html");// No I18N
        	response.setCharacterEncoding("UTF-8");// No I18N
        	PrintWriter out = response.getWriter();
        	out.write(resultString);
        */
		return "success";
	}
	private void getResultString(String inputString, int i, int j, int n, String tempString)
	{
		if(n==i)
		{
			resultString += " "+ tempString;
			return;
		}
		tempString += inputString.charAt(i);
		getResultString(inputString, i+1, j+1, n, tempString);
		tempString = tempString.substring(0, j);
		if(tempString.isEmpty())
		{
			return;
		}
		tempString+="."+inputString.charAt(i);
		getResultString(inputString, i+1, j+2, n, tempString);
		
	}
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
	public StringParserBean getModel() {
		if (parserBean == null)
        {
			parserBean = new StringParserBean();
        }
        return parserBean;
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
