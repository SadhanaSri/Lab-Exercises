package collections_practise;

import java.util.Enumeration;
import java.util.Hashtable;

public class Program11 {
	public static void main(String[] args) {
		Hashtable<String, Double> balance = new Hashtable<>();
		Enumeration<String> names;
		
		String str;
		double bal;
		
		balance.put("A", 12.34);
		balance.put("B", -12.34);
		balance.put("C", 123.34);
		balance.put("D", 132.34);
		balance.put("E", 111.34);
		balance.put("F", 133.34);
		
		names = balance.keys();
		
		while(names.hasMoreElements()) {
			str = names.nextElement();
			System.out.println(str+ ": "+balance.get(str));
		}
		
		bal = balance.get("A");
		balance.put("A", bal+1000);
		System.out.println(balance.get("A"));
	}
}
