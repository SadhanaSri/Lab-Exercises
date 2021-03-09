package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket client;
	BufferedReader br;
	BufferedReader in;
	PrintWriter out;
	static int i;
	
	public Client() {
		try {
			while(true) {
				System.out.println("Client: "+(i++));
				client = new Socket("localhost", 3000);
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String msgFromServer = br.readLine();
				System.out.println("Message from Sever: "+msgFromServer);
				
				out = new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter message for Server: ");
				String msg = in.readLine();
				out.println(msg);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		new Client();
	}
}
