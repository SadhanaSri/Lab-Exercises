package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBUtility;

public class LoginAction extends Action{
	Connection con;
	PreparedStatement st;
	String result;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			con = DBUtility.getConnection();
			st = con.prepareStatement("select * from users where uname=?");
			
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			
			HttpSession session=request.getSession();
			session.setAttribute("uname", name);
			session.setAttribute("upass", pass);
			
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
		
			if(rs.next() == false) {
				result =  "login.failure";	
			}
			else {
				int flag = rs.getInt("flag");
				String upass = rs.getString("upass");
				
				if(upass.equals(pass)) {
					if(flag == 0) {
						PreparedStatement update = con.prepareStatement("update users set flag=1 where uname=?");
						update.setString(1, name);
						if(update.executeUpdate() == 1) 
							result = "login.success";
						else 
							result = "login.failure";	
					} else {
						result = "login.stay";
					}
				} else {
					result =  "login.failure";	
				}				
			}
			DBUtility.closeConnection(null);
			return result;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return result;
		}
	}
}
