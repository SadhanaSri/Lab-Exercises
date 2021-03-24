package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement st;
	RequestDispatcher rd;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
			
		ServletContext sc = getServletContext();
		sc.setAttribute("name", request.getParameter("name"));
		String name = String.valueOf(sc.getAttribute("name"));
		
		try {
			con = DBUtility.getConnection();
			st = con.prepareStatement("select * from users where uname=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			
			if(rs.next() == false) {
				rd = request.getRequestDispatcher("register.html");
				rd.forward(request, response);
				
			}
			else {
					int flag = rs.getInt("flag");
					System.out.println("flag..........."+flag);
					if(flag == 0) {
						PreparedStatement update = con.prepareStatement("update users set flag=1 where uname=?");
						update.setString(1, name);
						System.out.println(update.executeUpdate());
						rd = request.getRequestDispatcher("welcome.html");
						rd.forward(request, response);
					} else {
						rd = request.getRequestDispatcher("login.html");
						rd.forward(request, response);
					}
				
			}
			DBUtility.closeConnection(null);
		} catch (SQLException e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
