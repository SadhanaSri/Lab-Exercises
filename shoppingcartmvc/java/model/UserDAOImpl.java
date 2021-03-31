package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class UserDAOImpl implements UserDAO, Cloneable {
	public static UserDAOImpl userDAOImpl;
	Properties prop;
	Connection con;
	int count;
	PreparedStatement st;
	
	public UserDAOImpl(Properties prop) {
		this.prop = prop;
	}
	
	public static UserDAOImpl getUserDAOImpl(Properties prop) {
		if(userDAOImpl == null) {
			return new UserDAOImpl(prop);
		} else {
			return userDAOImpl.createClone();
		}
	}
	
	public UserDAOImpl createClone() {
		try {
			return (UserDAOImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertUser(UserDTO userDTO) {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("insert into users values (?, ?, ?, ?)");
			st.setInt(1, userDTO.getId());
			st.setString(2, userDTO.getName());
			st.setString(3, userDTO.getPass());
			st.setInt(4, userDTO.getFlag());
			count = st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		try {	
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("update users set uname=?,upass=?,flag=? where uid=?");
			st.setString(1, userDTO.getName());
			st.setString(2, userDTO.getPass());
			st.setInt(3, userDTO.getFlag());
			st.setInt(4, userDTO.getId());
			count=st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUser(int uid) {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("delete from users where uid=?");
			st.setInt(1, uid);
			count = st.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UserDTO getUserDTO(int uid) {
		try {
			con = DBUtility.getConnection(prop);
			UserDTO userDTO = UserDTO.getUserDTO();
			st = con.prepareStatement("select * from users where uid=?");
			st.setInt(1, uid);
			ResultSet rs = st.executeQuery();
			
			userDTO.setId(rs.getInt(1));
			userDTO.setName(rs.getString(2));
			userDTO.setPass(rs.getString(3));
			userDTO.setFlag(rs.getInt(4));
			
			DBUtility.closeConnection(null);
			return userDTO;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDTO getUserByName(String uname) {
		try {
			con = DBUtility.getConnection(prop);
			UserDTO userDTO = UserDTO.getUserDTO();
			st = con.prepareStatement("select * from users where uname=?");
			st.setString(1, uname);
			ResultSet rs = st.executeQuery();
			
			if(rs.next() == false) {
				return null;
			} 
			
			userDTO.setId(rs.getInt(1));
			userDTO.setName(rs.getString(2));
			userDTO.setPass(rs.getString(3));
			userDTO.setFlag(rs.getInt(4));
			
			DBUtility.closeConnection(null);
			return userDTO;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<UserDTO> getAllUserDTO() {
		try {
			con = DBUtility.getConnection(prop);
			Set<UserDTO> set = new HashSet<>();
			UserDTO userDTO =UserDTO.getUserDTO();
			st = con.prepareStatement("select * from users");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				userDTO.setId(rs.getInt(1));
				userDTO.setName(rs.getString(1));
				userDTO.setPass(rs.getString(2));
				userDTO.setFlag(rs.getInt(3));
				set.add(userDTO);
			}
			DBUtility.closeConnection(null);
			return set;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getNewId() {
		try {
			con = DBUtility.getConnection(prop);
			st = con.prepareStatement("select count(*) from users");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			System.out.println(count);
			DBUtility.closeConnection(null);
			return count+1;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return 0;
	}
}
