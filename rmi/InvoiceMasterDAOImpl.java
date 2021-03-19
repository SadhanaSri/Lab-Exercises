package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	Connection con;
	PreparedStatement insertInvoice;
	PreparedStatement updateInvoice;
	PreparedStatement deleteInvoice;
	PreparedStatement getInvoice;
	InvoiceMasterDTO details;
	Statement st;
	static int count=0;
		
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		try {
			con = DBUtility.getConnection();
			String insertString = "insert into invoice values (?, ?, ?)";
			insertInvoice = con.prepareStatement(insertString);
		
			insertInvoice.setInt(1, invMasterDTO.getInvno());
			insertInvoice.setString(2, String.valueOf(invMasterDTO.getInvDate())); //;
			insertInvoice.setInt(3, invMasterDTO.getCustomerno());
			
			count = insertInvoice.executeUpdate();
			insertInvoice.close();
			DBUtility.closeConnection(null);			
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int deleteInvoice(int invNo) {
		try {
			con = DBUtility.getConnection();
			String deleteString = "delete from invoice where invNo=?";
			deleteInvoice = con.prepareStatement(deleteString);
			deleteInvoice.setInt(1, invNo);
			count = deleteInvoice.executeUpdate();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO){
		try {
			con = DBUtility.getConnection();
			String updateString = "update invoice set custNo=? where invNo=?";
			updateInvoice = con.prepareStatement(updateString);
			int invNo = invMasterDTO.getInvno();
			
			System.out.println("Enter new customer number for invoice no: "+invNo);
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			updateInvoice.setInt(1, no);
			updateInvoice.setInt(2, invMasterDTO.getInvno());
			
			count = updateInvoice.executeUpdate();	
			updateInvoice.close();
			sc.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		} 
		return count;
	}
	
	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invNo) {
		try {
			con = DBUtility.getConnection();
			String getString = "select * from invoice where invNo=?";
			getInvoice = con.prepareStatement(getString);
			
			getInvoice.setInt(1, invNo);
			
			ResultSet rs = getInvoice.executeQuery();
			details = new InvoiceMasterDTO();
			while(rs.next()) {
				details.setInvno(rs.getInt("invNo"));
				details.setInvDate(LocalDate.parse(rs.getString("invDate")));
				details.setCustomerno(rs.getInt("custNo"));
			}
			
			getInvoice.close();
			DBUtility.closeConnection(null);
		} catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		} 
		
		return details;
	}
	
	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		Set<InvoiceMasterDTO> set = new HashSet<>();
		
		try {
			con = DBUtility.getConnection();
			String get = "select * from invoice";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(get);
			
			while(rs.next()) {
				details = new InvoiceMasterDTO();
				details.setInvno(rs.getInt("invNo"));
				details.setInvDate(LocalDate.parse(rs.getString("invDate")));
				details.setCustomerno(rs.getInt("custNo"));
				set.add(details);
			}		
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		} 
		
		return set;
	}
}
