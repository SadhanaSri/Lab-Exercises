package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
//	private static Properties prop;
	static {
		try {
//			prop = new Properties();
//			prop.load(new FileInputStream("dbconfig.properties"));
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
	
	synchronized public static Connection getConnection() {
		Connection con = tlocal.get();
		if(con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "@sadhanakalyan1822");
				con.setAutoCommit(false);
				tlocal.set(con);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	synchronized public static void closeConnection(Exception e) {
		Connection con = tlocal.get();
		try {
			if(con != null) {
				if(e == null) {
					con.commit();
				} else {
					con.rollback();
					con.commit();
				}
				tlocal.remove();
				con.close();
			}
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	} 
}
