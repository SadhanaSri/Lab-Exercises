package day18;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;

public class Jdbc4 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "@sadhanakalyan1822");
		
		Savepoint sp = null;
		Statement st = null;
		
		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			st.execute("insert into users values (3, 'rio', 'rio', 0)");
			sp = con.setSavepoint("uptoinsert");
			st.execute("update users set flag=1 where uid=1");
			st.execute("update users set flag=1 where uuid=1");
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback(sp);
				con.commit();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
