package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtility;

public class LoginAction implements Action{
	Connection con;
	PreparedStatement st;
	RequestDispatcher rd;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from users where uname=?");
		
			String name = request.getParameter("name");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
		
			if(rs.next() == false) {
				return "login.failure";	
			}
			else {
				int flag = rs.getInt("flag");
				System.out.println("flag..........."+flag);
				if(flag == 0) {
					PreparedStatement update = con.prepareStatement("update users set flag=1 where uname=?");
					update.setString(1, name);
					System.out.println(update.executeUpdate());
				} else {
					return "login.stay";
				}
			}
			DBUtility.closeConnection(null);
			return "login.success";
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return "login.failure";
		}
	}
}
