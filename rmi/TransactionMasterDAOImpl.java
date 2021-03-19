package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionMasterDAOImpl implements TransactionMasterDAO {
	
	Connection con;
	PreparedStatement insertTransaction;
	PreparedStatement updateTransaction;
	PreparedStatement deleteTransaction;
	PreparedStatement getTransaction;
	TransactionMasterDTO details;
	Statement st;
	static int count;
		

	@Override
	public int insertTransaction(TransactionMasterDTO transMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String insertString = "insert into itemTransaction values (?, ?, ?)";
			insertTransaction = con.prepareStatement(insertString);
		
			insertTransaction.setInt(1, transMasterDTO.getInvno());
			insertTransaction.setInt(2, transMasterDTO.getItemNo());
			insertTransaction.setInt(3, transMasterDTO.getQty());
			
			count = insertTransaction.executeUpdate();
			insertTransaction.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public int deleteTransaction(int invNo) {
		try {
			con = DBUtility.getConnection();
			String deleteString = "delete from itemTransaction where invNo=?";
			deleteTransaction = con.prepareStatement(deleteString);
			deleteTransaction.setInt(1, invNo);
			count = deleteTransaction.executeUpdate();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public int updateTransaction(TransactionMasterDTO transMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String updateString = "update itemTransaction set itemQty=? where invNo=?";
			updateTransaction = con.prepareStatement(updateString);
			System.out.println("Enter customer new item qty for update: ");
			Scanner sc = new Scanner(System.in);
			int qty = sc.nextInt();
			updateTransaction.setFloat(1, qty);
			updateTransaction.setInt(2, transMasterDTO.getInvno());
			
			count = updateTransaction.executeUpdate();	
			updateTransaction.close();
			sc.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return count;
	}

	@Override
	public TransactionMasterDTO getTransactionMaster(int invNo) {
		try {
			con = DBUtility.getConnection();
			String getString = "select * from itemTransaction where invNo=?";
			getTransaction = con.prepareStatement(getString);
			
			getTransaction.setInt(1, invNo);
			
			ResultSet rs = getTransaction.executeQuery();
			details = new TransactionMasterDTO();
			
			while(rs.next()) {
				details.setInvno(rs.getInt("invNo"));
				details.setItemNo(rs.getInt("itemNo"));
				details.setQty(rs.getInt("itemQty"));
			}
			
			getTransaction.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return details;
	}

	@Override
	public Set<TransactionMasterDTO> getTransactionMasterAll() {
		Set<TransactionMasterDTO> set = new HashSet<>();
		try {
			con = DBUtility.getConnection();
			String get = "select * from itemTransaction";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(get);
			details = new TransactionMasterDTO();
			while(rs.next()) {
				details.setInvno(rs.getInt("invNo"));
				details.setItemNo(rs.getInt("itemNo"));
				details.setQty(rs.getInt("itemQty"));
				set.add(details);
			}		
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		
		return set;
	}

	
}
