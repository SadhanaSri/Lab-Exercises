package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtility;

public class RegisterAction implements Action {
	Connection con;
	PreparedStatement st;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
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
			DBUtility.closeConnection(null);
			return "register.success";
		} catch (SQLException e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return "register.failure";
		}	
	}
}
