package com;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called..");
		String value = config.getInitParameter("name");
		System.out.println("Init param value...."+value);
		
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String val = config.getInitParameter(name);
			System.out.println(name+":"+val);
		}
		ServletContext ctx = config.getServletContext();
		ctx.setAttribute("globalkey", "value"); //can be accessed globally
		String path = ctx.getRealPath("/WEB-INF/demo.properties");
		System.out.println(path);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called....");
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		System.out.println(uname+":"+upass);
		
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+":"+value);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post called....");
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy called...");
	}
}
