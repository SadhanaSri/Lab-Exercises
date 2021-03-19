package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CustomerMasterDAOImpl implements CustomerMasterDAO {
	
	Connection con;
	PreparedStatement insertCustomer;
	PreparedStatement updateCustomer;
	PreparedStatement deleteCustomer;
	PreparedStatement getCustomer;
	CustomerMasterDTO details;
	Statement st;
	static int count;
	
	@Override
	public int insertCustomer(CustomerMasterDTO custMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String insertString = "insert into customerMaster values (?, ?, ?, ?, ?)";
			insertCustomer = con.prepareStatement(insertString);
			
			insertCustomer.setInt(1, custMasterDTO.getCustNo());
			insertCustomer.setString(2, custMasterDTO.getCustName());
			insertCustomer.setString(3, custMasterDTO.getCustAddress());
			insertCustomer.setString(4, custMasterDTO.getCustEmail());
			insertCustomer.setString(5, custMasterDTO.getCustPhone());
			
			count = insertCustomer.executeUpdate();
			insertCustomer.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		return count;
	}

	@Override
	public int deleteCustomer(int custNo) {
		try {
			con = DBUtility.getConnection();
			String deleteString = "delete from customerMaster where custNo=?";
			deleteCustomer = con.prepareStatement(deleteString);
			deleteCustomer.setInt(1, custNo);
			count = deleteCustomer.executeUpdate();
			deleteCustomer.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		return count;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO custMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String updateString = "update customerMaster set custPhone=? where custNo=?";
			updateCustomer = con.prepareStatement(updateString);
			System.out.println("Enter customer new phone number for update: ");
			Scanner sc = new Scanner(System.in);
			String phone = sc.next();
			
			updateCustomer.setString(1, phone);
			updateCustomer.setInt(2, custMasterDTO.getCustNo());
		
			count = updateCustomer.executeUpdate();	
			updateCustomer.close();
			sc.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		return count;
	}

	@Override
	public CustomerMasterDTO getCustomerMaster(int custNo) {
		try {
			con = DBUtility.getConnection();
			String getString = "select * from customerMaster where custNo=?";
			getCustomer = con.prepareStatement(getString);
			
			getCustomer.setInt(1, custNo);
			
			ResultSet rs = getCustomer.executeQuery();
			details = new CustomerMasterDTO();
			
			while(rs.next()) {
				details.setCustNo(rs.getInt("custNo"));
				details.setCustName(rs.getString("custName"));
				details.setCustAddress(rs.getString("custAddress"));
				details.setCustEmail(rs.getString("custEmail"));
				details.setCustPhone(rs.getString("custPhone"));
			}

			getCustomer.close();
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		} 
		return details;
	}

	@Override
	public Set<CustomerMasterDTO> getCustomerMasterAll() {
		Set<CustomerMasterDTO> set = new HashSet<>();
		try {
			con = DBUtility.getConnection();
			String get = "select * from customerMaster";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(get);
			
			while(rs.next()) {
				details = new CustomerMasterDTO();
				details.setCustNo(rs.getInt("custNo"));
				details.setCustAddress(rs.getString("custAddress"));
				details.setCustEmail(rs.getString("custEmail"));
				details.setCustPhone(rs.getString("custPhone"));
				set.add(details);
			}
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		} 	
		return set;
	}
	
}
