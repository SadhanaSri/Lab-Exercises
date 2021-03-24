package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBUtility;

public class LogOutAction extends Action {
	Connection con;
	PreparedStatement st;
	String result;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session=request.getSession();
			String name=(String)session.getAttribute("uname");
			
			con = DBUtility.getConnection();
			st = con.prepareStatement("update users set flag=0 where uname=?");
			st.setString(1, name);
			if(st.executeUpdate() == 1)
				result = "logout.success";
			else
				result = "logout.failure";
			DBUtility.closeConnection(null);
			return result;
		} catch (SQLException e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return result;
		}
	}
}
