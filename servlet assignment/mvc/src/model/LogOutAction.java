package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtility;

public class LogOutAction implements Action {
	Connection con;
	PreparedStatement st;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("name");
			con = DBUtility.getConnection();
			st = con.prepareStatement("update users set flag=0 where uname=?");
			st.setString(1, name);
			st.executeUpdate();
			DBUtility.closeConnection(null);
			return "logout.success";
		} catch (SQLException e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return "logout.failure";
		}
	}
}
