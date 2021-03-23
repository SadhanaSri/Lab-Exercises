package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement st;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "root");
			st = con.prepareStatement("insert into data values (?, ?)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("age");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Inserting Record</h1>");
		
		int age = Integer.parseInt(s2);
		try {
			st.setString(1, s1);
			st.setInt(2, age);
			int count = st.executeUpdate();
			if(count==1) {
				pw.println("<h1>Inserted successfully</h1>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
