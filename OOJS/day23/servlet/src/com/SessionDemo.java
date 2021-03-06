package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletOutputStream out = response.getOutputStream();
		Object obj = session.getAttribute("count");
		if(obj == null) {
			session.setAttribute("count", 1);
			out.println("<h1>You are visiting for the first time...");
		} else {
			out.println("<h1>This is not your first time...you are visiting"+obj.toString());
			String s=obj.toString();
			int x=Integer.parseInt(s);
			session.setAttribute("count", ++x);
		}
	}
}
