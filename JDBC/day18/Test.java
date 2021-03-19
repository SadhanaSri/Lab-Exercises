package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	 public static void main(String str[]) throws Exception 
	   { 
	 try 
	 { 
	 Class.forName("com.mysql.cj.jdbc.Driver"); 
	 //establish connection 
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "@sadhanakalyan1822");
	 
	 System.out.println(con); 
//	  Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); 
//	  Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
	 Statement st=con.createStatement(); 
	 ResultSet rs=st.executeQuery("select * from users"); 
	 while(rs.next()) 
	 { 
	 } 
	  rs.afterLast(); 
	 while(rs.previous()) 
	 { 
		 int e1=rs.getInt(1); 
		 String e=rs.getString(2); 
		 System.out.println("name = " +e1 +"age = " +e); 
		 } 
		 st.close(); 
		 con.close(); 
		 } 
		 catch(Exception e){e.printStackTrace();} 
		 
		   } 
		} 
