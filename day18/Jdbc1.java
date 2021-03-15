package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DatabaseMetaData;

public class Jdbc1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "");
		
//		metadata
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println(dbmd.getDatabaseMajorVersion());
		System.out.println(dbmd.getDatabaseMinorVersion());
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getDriverName());
		System.out.println(dbmd.getStringFunctions());
		System.out.println(dbmd.getSQLKeywords());
		
		con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from users");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("No of columns:"+rsmd.getColumnCount());
		System.out.println("Table name:"+rsmd.getTableName(1));
		
		for(int i=1; i<=rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		
		while(rs.next()) {
			int uid = rs.getInt(1);
			String uname = rs.getString("uname");
			String upass = rs.getString("upass");
			int flag = rs.getInt("flag");
			System.out.print("\n"+uid+"\t"+uname+"\t"+upass+"\t"+flag);
		}
		
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = st.executeQuery("select * from users");
	
		while(rs.next()) {
			
		}
		
		while(rs.previous()) {
			int uid = rs.getInt(1);
			String uname = rs.getString("uname");
			String upass = rs.getString("upass");
			int flag = rs.getInt("flag");
			System.out.print("\n"+uid+"\t"+uname+"\t"+upass+"\t"+flag);
		}
		
		PreparedStatement ps = con.prepareStatement("select * from users where uid<=?");
		Scanner sc = new Scanner(System.in);
		int id=sc.nextInt();
		ps.setInt(1, id);
		rs = ps.executeQuery();
		System.out.println("user with id < "+id);
		
		while(rs.next()) {
			System.out.println(rs.getString("uname"));
		}
		sc.close();
		st.close();
		con.close();
	}
}
