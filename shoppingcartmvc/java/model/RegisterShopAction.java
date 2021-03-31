package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterShopAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		Properties prop = (Properties)request.getServletContext().getAttribute("properties");
		
		if(upass.length() != 0) {
			UserDTO userDTO = UserDTO.getUserDTO();
			UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
			userDTO.setId(userDAO.getNewId());
			userDTO.setName(uname);
			userDTO.setPass(upass);
			userDTO.setFlag(0);
			
			LoginService register = LoginServiceImpl.getLoginServiceImpl(prop);	
			register.registerUser(userDTO);
			
			return "register.success";
		} 
		
		return "register.failure";
	}
}
