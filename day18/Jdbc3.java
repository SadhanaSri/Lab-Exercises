package day18;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Jdbc3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "");
		
		CallableStatement cs = con.prepareCall("{call proc1(?, ?)}");
		cs.setInt(1, 1);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		System.out.println(cs.getString(2));
		
		cs = con.prepareCall("{call myproc2(?, ?)}");
		cs.setString(1, "ramu");
		cs.registerOutParameter(2, Types.INTEGER);
		cs.execute();
		int flag = cs.getInt(2);
		System.out.println("Flag of ramu is "+flag);
		
		cs = con.prepareCall("{call myproc(?, ?)}");
		cs.setInt(1, 0);
		cs.setString(2, "ramu");
		cs.execute();
		
		cs = con.prepareCall("{call myproc2(?, ?)}");
		cs.setString(1, "ramu");
		cs.registerOutParameter(2, Types.INTEGER);
		cs.execute();
		flag = cs.getInt(2);
		System.out.println("Flag of ramu is "+flag);
	} 
}
