package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBUtility;

public class RegisterAction extends Action {
	Connection con;
	PreparedStatement st;
	String result;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("uname");
		String pass = (String)session.getAttribute("upass");
		
		if(pass.length() != 0) {
			try {
				con = DBUtility.getConnection();
				st = con.prepareStatement("select count(*) from users");
				ResultSet rs = st.executeQuery();
				int count=0;
				
				count = rs.getInt(1);
				
				st = con.prepareStatement("insert into users values (?, ?, ?, 0)");
				st.setInt(1, ++count);
				st.setString(2, name);
				st.setString(3, pass);
				st.executeUpdate();
				
				DBUtility.closeConnection(null);
				result = "register.success";
			} catch (SQLException e) {
				DBUtility.closeConnection(e);
				e.printStackTrace();
				result = "register.failure";
			}	
		} else {
			result = "register.failure";
		}
		return result;
	}
}
