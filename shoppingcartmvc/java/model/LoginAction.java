package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		Properties prop = (Properties) request.getServletContext().getAttribute("properties"); 
		HttpSession session = request.getSession();
		
		LoginService login = LoginServiceImpl.getLoginServiceImpl(prop);
		
		if(login.checkUser(uname, upass)) {
			if(login.checkFlag(uname)) {
				login.updateFlag(uname, 1);
				session.setAttribute("uname", uname);
				session.setAttribute("upass", upass);
				return "login.success";
			} else {
				return "login.stay";
			}
		}
		return "login.failure";
	}
}
