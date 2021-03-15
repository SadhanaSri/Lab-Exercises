package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Jdbc6 {
	public static void main(String[] args) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "");
		 
		 Enumeration e = DriverManager.getDrivers();
		 System.out.println(" "+DriverManager.getLoginTimeout());
		 
		 while(e.hasMoreElements()) {
			 System.out.println(e.nextElement());
		 }
		 con.close();
		
	}
}
