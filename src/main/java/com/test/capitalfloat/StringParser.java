//$Id$
package com.test.capitalfloat;

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

public class StringParser extends ApplicationBean implements ModelDriven<StringParserBean>{
	private StringParserBean parserBean = null;
	private String resultString = "";
    
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
	
	@Override
	public StringParserBean getModel() {
		if (parserBean == null)
        {
			parserBean = new StringParserBean();
        }
        return parserBean;
	}
}
