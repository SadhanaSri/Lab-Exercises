package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement stmt;
	PreparedStatement st;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		try {
			con = DBUtility.getConnection();
			st = con.prepareStatement("select count(*) from users");
			ResultSet rs = st.executeQuery();
			int count=0;
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			st = con.prepareStatement("insert into users values (?, ?, ?, 0)");
			st.setInt(1, ++count);
			st.setString(2, name);
			st.setString(3, pass);
			System.out.println(st.executeUpdate());
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
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
