package day16;

import java.net.InetAddress;

public class InetDemo {
	public static void main(String[] args) throws Exception {
		InetAddress inetadd = InetAddress.getByName("www.google.com");
		System.out.println(inetadd.getHostAddress());
		
		InetAddress inetarr[] = InetAddress.getAllByName("www.irctc.con.in");
		for(InetAddress a: inetarr) {
			System.out.println(a.getHostAddress());
		}
		
		InetAddress inetName = InetAddress.getByAddress(new byte[] {103, 10, 10, 18});
		
		System.out.println(inetName.getHostName());
	}
}
