package day18;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc5 {
	public static void main(String[] args) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "@sadhanakalyan1822");
		 Statement st = con.createStatement();
		 st.execute("drop table coffee");
	}
}
