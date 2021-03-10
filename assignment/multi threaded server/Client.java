package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    
    public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("127.0.0.1",5000);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			System.out.print("Client : ");
			s=stdin.readLine();
			sout.println(s);
                        if ( s.equalsIgnoreCase("BYE") )
                        {
                           System.out.println("Connection ended by client");
 			   break;
                        }
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();
	}
    
}
//public class Client {
//	Socket s;
//	BufferedReader br;
//	BufferedReader in;
//	PrintWriter out;
//	static int i;
//	
//	public Client() {
//		try {
//			s = new Socket("localhost", 3000);
//			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			in = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(s.getOutputStream(), true);
//			
//			while(true) {
//				String msgFromServer = br.readLine();
//				System.out.println("Message from Sever: "+msgFromServer);
//							
//				System.out.println("Enter message for Server: ");
//				String msg = in.readLine();
//				out.println(msg);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//		
//	public static void main(String[] args) {
//		new Client();
//	}
//}
