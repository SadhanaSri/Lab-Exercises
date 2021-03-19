package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "@sadhanakalyan1822");
		
		PreparedStatement updateSales; //= con.prepareStatement("update coffees where name=? set total=100");
		PreparedStatement updateTotal;
		
		String updateString = "update coffees " + "set sales = ? where name = ?";
        String updateStatement = "update coffees " + "set total = total + ? where name = ?";                            
        
        String query = "select * from COFFEES";
        updateSales = con.prepareStatement(updateString);
        updateTotal = con.prepareStatement(updateStatement);
		
		int [] salesForWeek = {175, 150};
        String [] coffees = {"espresso", "cappuchino"};
        int length = coffees.length;
        
        for(int i=0; i<length; i++) {
        	updateSales.setInt(1, salesForWeek[i]);
        	updateSales.setString(2, coffees[i]);
        	updateSales.executeUpdate();
        	updateTotal.setInt(1, salesForWeek[i]);
            updateTotal.setString(2, coffees[i]);
            updateTotal.executeUpdate();
//            con.commit();       
        }
		con.setAutoCommit(true);
		updateSales.close();
        updateTotal.close();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
         String c = rs.getString("name");
         int s = rs.getInt("sales");
         int t = rs.getInt("total");
         System.out.println(c + "     " +  s + "    " + t);
        }

        stmt.executeUpdate("insert into coffee values('black', 30, 30)");
		rs = stmt.executeQuery("select * from coffee");
		
		while(rs.next()) {
			String name = rs.getString("name");
			int sales = rs.getInt(1);
			int total = rs.getInt(2);
			System.out.print("\n"+name+"\t"+sales+"\t"+total);
		}
		
	}
}
