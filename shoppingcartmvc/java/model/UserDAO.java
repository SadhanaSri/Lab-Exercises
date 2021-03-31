package model;

import java.util.Set;

public interface UserDAO {
	public int insertUser(UserDTO userDTO);
	public int updateUser(UserDTO userDTO);
	public int deleteUser(int uid);
	public UserDTO getUserDTO(int uid);
	public UserDTO getUserByName(String uname);
	public Set<UserDTO> getAllUserDTO();
	public int getNewId();
}
