package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ItemMasterDAOImpl implements ItemMasterDAO {	
	Connection con;
	PreparedStatement insertItem;
	PreparedStatement updateItem;
	PreparedStatement deleteItem;
	PreparedStatement getItem;
	ItemMasterDTO details;
	Statement st;
	static int count;
	

	@Override
	public int insertItem(ItemMasterDTO itemMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String insertString = "insert into itemMaster values (?, ?, ?, ?)";
			insertItem = con.prepareStatement(insertString);
		
			insertItem.setInt(1, itemMasterDTO.getItemNo());
			insertItem.setString(2, itemMasterDTO.getItemName());
			insertItem.setInt(3, itemMasterDTO.getItemUnit());
			insertItem.setFloat(4, itemMasterDTO.getItemPrice());
			
			
			count = insertItem.executeUpdate();
			insertItem.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public int deleteItem(int itemNo) {
		try {
			con = DBUtility.getConnection();
			String deleteString = "delete from itemMaster where itemNo=?";
			deleteItem = con.prepareStatement(deleteString);
			deleteItem.setInt(1, itemNo);
			count = deleteItem.executeUpdate();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public int updateItem(ItemMasterDTO itemMasterDTO) throws Exception {
		try {
			con = DBUtility.getConnection();
			String updateString = "update itemMaster set itemPrice=? where itemNo=?";
			updateItem = con.prepareStatement(updateString);
			System.out.println("Enter item price for update: ");
			Scanner sc = new Scanner(System.in);
			int price = sc.nextInt();
			updateItem.setFloat(1, price);
			updateItem.setInt(2, itemMasterDTO.getItemNo());
			
			count = updateItem.executeUpdate();	
			updateItem.close();
			sc.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public ItemMasterDTO getItemMaster(int itemNo) throws Exception {
		try {
			con = DBUtility.getConnection();
			String getString = "select * from itemMaster where itemNo=?";
			getItem = con.prepareStatement(getString);
			
			getItem.setInt(1, itemNo);
			
			ResultSet rs = getItem.executeQuery();
			details = new ItemMasterDTO();
			
			while(rs.next()) {
				details.setItemNo(rs.getInt("itemNo"));
				details.setItemName(rs.getString("itemName"));
				details.setItemUnit(rs.getInt("itemUnit"));
				details.setItemPrice(rs.getFloat("itemPrice"));
			}
			
			getItem.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return details;
	}

	@Override
	public Set<ItemMasterDTO> getItemMasterAll() throws Exception {
		Set<ItemMasterDTO> set = new HashSet<>();
		try {
			con = DBUtility.getConnection();
			String get = "select * from itemMaster";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(get);
			
			while(rs.next()) {
				details = new ItemMasterDTO();
				details.setItemNo(rs.getInt("itemNo"));
				details.setItemName(rs.getString("itemName"));
				details.setItemUnit(rs.getInt("itemUnit"));
				details.setItemPrice(rs.getFloat("itemPrice"));
				set.add(details);
			}		
			DBUtility.closeConnection(null);
			return set;
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		return set;
	}
	
}
