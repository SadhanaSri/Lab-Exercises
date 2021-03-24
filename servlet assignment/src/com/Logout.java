package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement st;
	RequestDispatcher rd;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String name = (String)sc.getAttribute("name");
		try {
			con = DBUtility.getConnection();
			st = con.prepareStatement("update users set flag=0 where uname=?");
			st.setString(1, name);
			st.executeUpdate();
			rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			DBUtility.closeConnection(null);
		} catch (SQLException e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
