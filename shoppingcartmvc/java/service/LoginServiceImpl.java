package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import model.UserDAO;
import model.UserDAOImpl;
import model.UserDTO;

public class LoginServiceImpl implements LoginService, Cloneable {
	Properties prop;
	Connection con;
	PreparedStatement st;
	
	public LoginServiceImpl(Properties prop) {
		this.prop = prop;
	}
	
	public static LoginServiceImpl loginServiceImpl;
	
	public static LoginServiceImpl getLoginServiceImpl(Properties prop) {
		if(loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl(prop);
			return loginServiceImpl;
		} else {
			return loginServiceImpl.createClone();
		}
	}	
	
	public LoginServiceImpl createClone() {
		try {
			return (LoginServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserByName(uname);
		
		if(userDTO != null) {
			if((userDTO.getPass()).equals(upass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkFlag(String uname) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserByName(uname);
		
		if(userDTO.getFlag() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int updateFlag(String uname, int flag) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserByName(uname);
		if(userDTO != null) {
			userDTO.setFlag(flag);
			return userDAO.updateUser(userDTO);
		}
		return 0;
	}

	@Override
	public int registerUser(UserDTO userDTO) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);	
		return userDAO.insertUser(userDTO);
	}

}
